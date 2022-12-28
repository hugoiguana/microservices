start_apps:
	@echo "Starting apps"
	chmod 777 sql/ms-sales/config-db.sh
	docker compose up -d db-ms-sales --build

clean_apps:
		docker compose down
		docker volume rm db-ms-sales
