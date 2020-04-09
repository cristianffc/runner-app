delete from users;
delete from authorities;

insert into users (id, username, password, enabled)
    values ('1', 'mind', '$2a$12$URBJjF5CN1MwPBRsTRqqFeyXzxvGpZZ50RgtJFRPlYBlDbkDoT2he','Y');

insert into authorities (id, username, authority)
    values ('1', 'mind', 'free');