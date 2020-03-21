

# make help
#  Display this help message

.PHONY: help
help:
	@printf 'Backend of HowToHelp\n\n'
	@awk -f Makefile.autodoc.awk Makefile
	@printf '\n'

# make package 
#  Builds the jar with maven and then the docker container.

.PHONY: package
package:
	mvn package 
	./scripts/build-docker-image.sh
