drop table roles if exists;
drop table users if exists;
CREATE TABLE public.users (
    id SERIAL primary key NOT NULL,
    username character varying(100) NOT NULL,
    password character varying(100) NOT NULL,
    tenant_id integer,
    email character varying(100) NOT NULL,
    enabled bit NOT NULL
);

CREATE TABLE public.roles (
    id SERIAL NOT NULL,
    role character varying(100) NOT NULL
);

INSERT INTO USERS (id,username,password,tenant_id,email,enabled) VALUES(1,'admin','$2a$10$xNBErwJMvxvs3d4ApNnqZubvQE8WyuyX5zyRxt1iT3oCZxStAe.TK',1,'admin@admin.com',true);
INSERT INTO USERS (id,username,password,tenant_id,email,enabled) VALUES(2,'Roberto','$2a$10$sU1IbIMIlXXUUaoYIDiM5uXIuieh2XTfnxAuSddcB0gMMC6G3TKZu',1,'rober@gmx.es',true);
INSERT INTO USERS (id,username,password,tenant_id,email,enabled) VALUES(3,'Pablo','$2a$10$NcJPwhNC6jatX3zWjAgR/O.1dNargsnGuswvCM/QVfEMqdEorbA1O',2,'pablo@pablo.com',true);
INSERT INTO ROLES (id,role) VALUES(1,'ROLE_ADMIN');
INSERT INTO ROLES (id,role) VALUES(2,'ROLE_USER');


INSERT INTO USER_ROLES (user_id,role_id) VALUES (1,1);
INSERT INTO USER_ROLES (user_id,role_id) VALUES (1,2);
INSERT INTO USER_ROLES (user_id,role_id) VALUES (2,2);
INSERT INTO USER_ROLES (user_id,role_id) VALUES (3,2);

