init:
	docker-compose up --build -d

destroy:
	docker-compose down --rmi all --volumes --remove-orphans