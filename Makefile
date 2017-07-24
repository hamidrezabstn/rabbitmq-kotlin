FILE_ARG=-f docker/docker-compose.yml
up:
	docker-compose $(FILE_ARG) up
upd:
	docker-compose $(FILE_ARG) up -d

