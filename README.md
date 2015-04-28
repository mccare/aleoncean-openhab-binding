aleoncean-openhab-binding
=========================

aleoncean openHAB v1.x binding

# Release

```sh
# There should be no changed stuff
git status

# Set current version string without SNAPSHOT (qualifier), or bump to the version the release should use.
mvn -DnewVersion="1.7.1" tycho-versions:set-version

# Ensure all is building and is working
mvn clean verify

# Checkin all changed files
git add . && git commit -m "[tycho release] set release version (manifest + pom)"

# Create tag for the current release
git tag v1.7.1

# Deploy release to a repository
mvn -DaltDeploymentRepository=pdrone::default::http://<user>:<pass>@<host>:<port>/<path> deploy

# Set next development version (use .qualifier, this will set -SNAPSHOT to pom.xml)
mvn -DnewVersion=1.7.2.qualifier tycho-versions:set-version

# Ensure all is building and is working
mvn clean verify

# Checkin all changed files
git add . && git commit -m "[tycho release] set next development version (manifest + pom)"
```
