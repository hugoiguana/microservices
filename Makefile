start:
	@echo "Starting apps"
	chmod 777 ms-sales/db/scripts/config-db.sh
	chmod 777 mvnw
	./mvnw clean package -f ms-sales/pom.xml
	docker compose up -d --build


stop:
	docker compose stop

clean:
	docker compose down
	docker volume rm db-ms-sales
