ROOT_DIR:=$(shell dirname $(realpath $(firstword $(MAKEFILE_LIST))))

include build.conf
export

build-local:
build-local: build-frontend-local build-backend-local

build-frontend-local:
build-frontend-local: clean-frontend
	 @ cd ${ROOT_DIR}/portfolio-frontend/ && ./build.sh -b "$$LOCAL_FRONTEND_BRANCH" -e "local"

build-backend-local:
build-backend-local: clean-backend
	 @ cd ${ROOT_DIR}/portfolio-backend/ && ./build.sh -b "$$LOCAL_BACKEND_BRANCH" -e "local"

start-local:
start-local:
	 @ docker compose -p portfolio up -d || echo "Docker Compose failed to execute!"

stop:
stop:
	@ docker container stop portfolio-frontend portfolio-backend portfolio-mysql certbot || true

clean:
clean: stop
	@ docker container rm -v portfolio-frontend portfolio-backend portfolio-mysql certbot || true
	@ docker image rm portfolio-frontend portfolio-backend || true

clean-backend:
clean-backend:
	@ docker container stop portfolio-backend || true
	@ docker container rm -v portfolio-backend || true
	@ docker image rm portfolio-backend || true

clean-frontend:
clean-frontend:
	@ docker container stop portfolio-frontend || true
	@ docker container rm -v portfolio-frontend || true
	@ docker image rm portfolio-frontend || true



