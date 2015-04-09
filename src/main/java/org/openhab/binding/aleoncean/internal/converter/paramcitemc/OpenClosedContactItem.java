package org.openhab.binding.aleoncean.internal.converter.paramcitemc;

import org.openhab.binding.aleoncean.internal.ActionIn;
import org.openhab.binding.aleoncean.internal.converter.NoValueException;
import org.openhab.binding.aleoncean.internal.converter.ParameterClassItemClassConverter;
import org.openhab.binding.aleoncean.internal.devices.ItemInfo;
import org.openhab.core.events.EventPublisher;
import org.openhab.core.items.Item;
import org.openhab.core.library.items.ContactItem;
import org.openhab.core.library.types.OpenClosedType;
import org.openhab.core.types.Command;
import org.openhab.core.types.State;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.aleon.aleoncean.values.OpenClosed;

public class OpenClosedContactItem extends ParameterClassItemClassConverter {

    private static final Logger LOGGER = LoggerFactory.getLogger(OpenClosedContactItem.class);

    public static final Class<?> PARAMETER_CLASS = OpenClosed.class;
    public static final Class<? extends Item> ITEM_CLASS = ContactItem.class;

    public OpenClosedContactItem(ActionIn actionIn) {
        super(actionIn);
    }

    private OpenClosedType openClosedToOpenClosedType(final OpenClosed i) throws NoValueException {
        switch (i) {
            case OPEN:
                return OpenClosedType.OPEN;
            case CLOSED:
                return OpenClosedType.CLOSED;
            default:
                throw new NoValueException("Cannot handle incoming value: " + i.toString());
        }
    }

    // private OpenClosed openClosedTypeToOpenClosed(final OpenClosedType i) throws NoValueException {
    // switch (i) {
    // case OPEN:
    // return OpenClosed.OPEN;
    // case CLOSED:
    // return OpenClosed.CLOSED;
    // default:
    // throw new NoValueException("Cannot handle incoming value: " + i.toString());
    // }
    // }

    @Override
    public void commandFromOpenHAB(EventPublisher eventPublisher, String itemName, ItemInfo itemInfo, Command command) {
        // We map incoming stuff from device to control the item.
        // We ignore incoming stuff from openHAB.
    }

    @Override
    public void stateFromOpenHAB(EventPublisher eventPublisher, String itemName, ItemInfo itemInfo, State state) {
        // We map incoming stuff from device to control the item.
        // We ignore incoming stuff from openHAB.
    }

    @Override
    public void parameterFromDevice(EventPublisher eventPublisher, String itemName, ItemInfo itemInfo, Object value) {
        assert PARAMETER_CLASS.isAssignableFrom(value.getClass());
        try {
            final OpenClosedType type = openClosedToOpenClosedType((OpenClosed) value);
            switch (getActionIn()) {
                case COMMAND:
                    LOGGER.warn("Action not supported: {}", getActionIn());
                    break;
                case STATE:
                case DEFAULT:
                    postUpdate(eventPublisher, itemName, type);
                    break;
                default:
                    LOGGER.warn("Don't know how to handle action in type: {}", getActionIn());
                    break;
            }
        } catch (final NoValueException ex) {
            LOGGER.warn("Conversion error.", ex);
        }
    }

}
