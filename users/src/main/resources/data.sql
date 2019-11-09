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

INSERT INTO USERS (id,username,password,tenant_id,email,enabled) VALUES(1,'admin','$2a$10$ES3fURAPIr5ei48pdPz80eXSH5SkXG1B12d2xjc1/B70YRKzfWDj6',1,'\xe3782c213aa94a669059f8d7baad31fc',true);
INSERT INTO USERS (id,username,password,tenant_id,email,enabled) VALUES(2,'Roberto','$2a$10$SdLXcC54llKYAlIK4jACL.0xY4PqJDYLjw9BIJseyG.ghc1Qd3KX6',1,'\xe3782c213aa94a669059f8d7baad31fc',true);
INSERT INTO USERS (id,username,password,tenant_id,email,enabled) VALUES(3,'Pablo','$2a$10$nDQqIK/BuLnHnoSmOi6g1.lzgUJGYXQBSU.ZkW/R3rcI4rreiBe9W',2,'\xe3782c213aa94a669059f8d7baad31fc',true);
INSERT INTO ROLES (id,role) VALUES(1,'ROLE_ADMIN');
INSERT INTO ROLES (id,role) VALUES(2,'ROLE_USER');


INSERT INTO USER_ROLES (user_id,role_id) VALUES (1,1);
INSERT INTO USER_ROLES (user_id,role_id) VALUES (1,2);
INSERT INTO USER_ROLES (user_id,role_id) VALUES (2,2);
INSERT INTO USER_ROLES (user_id,role_id) VALUES (3,2);

