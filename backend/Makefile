

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

# make start-postgresql 
#  Start the dependency postgres.

.PHONY: start-postgresql
start-postgresql:
	scripts/start-postgresql.sh

# make stop-postgresql 
#  Stop the dependency postgres.

.PHONY: stop-postgresql
stop-postgresql:
	scripts/stop-postgresql.sh

# make run 
#  Starts the dependency and after that starts the application.

.PHONY: run
run: 
	make start-postgresql
	scripts/run-application.sh local
