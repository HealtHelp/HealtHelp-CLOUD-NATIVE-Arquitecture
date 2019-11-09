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

INSERT INTO USERS (id,username,password,tenant_id,email,enabled) VALUES(1,'admin','$2a$10$qY2dtFq1m/wekG1r953AIupnYp6wkxXQ68dJBcS4dB/59zPhqldte',1,'\xe3782c213aa94a669059f8d7baad31fc',true);
INSERT INTO USERS (id,username,password,tenant_id,email,enabled) VALUES(2,'Roberto','$2a$10$Se58FeMiB75CROLc071N/OscqeZ3TGAe9yKmOUZNsoBJvy/m6XXuW',1,'\xe3782c213aa94a669059f8d7baad31fc',true);
INSERT INTO USERS (id,username,password,tenant_id,email,enabled) VALUES(3,'Pablo','$2a$10$FDhNWl.4lb0AdEr8Mvu9aeGHdddyi0lHwEJO/2sxewaBQt/jRIkgm',2,'\xe3782c213aa94a669059f8d7baad31fc',true);
INSERT INTO ROLES (id,role) VALUES(1,'ROLE_ADMIN');
INSERT INTO ROLES (id,role) VALUES(2,'ROLE_USER');


INSERT INTO USER_ROLES (user_id,role_id) VALUES (1,1);
INSERT INTO USER_ROLES (user_id,role_id) VALUES (1,2);
INSERT INTO USER_ROLES (user_id,role_id) VALUES (2,2);
INSERT INTO USER_ROLES (user_id,role_id) VALUES (3,2);

