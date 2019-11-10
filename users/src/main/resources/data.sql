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

INSERT INTO USERS (id,username,password,tenant_id,email,enabled) VALUES(1,'admin','$2a$10$IFdbxGGEp3T.ptTIeYkSOOA8vMregzHK4YZ61ivZ0jyI9XmBvfpWm',1,'\xe3782c213aa94a669059f8d7baad31fc',true);
INSERT INTO USERS (id,username,password,tenant_id,email,enabled) VALUES(2,'Roberto','$2a$10$66E6h9eIat/Gk.piqMghue.Zeci4.4YiiJfslDADD3JxFxrRCqe8G',1,'\xe3782c213aa94a669059f8d7baad31fc',true);
INSERT INTO USERS (id,username,password,tenant_id,email,enabled) VALUES(3,'Pablo','$2a$10$.0x6lBoZuC5oaE.mu63niOkOgdfce.gdPlSFNoNthfMAoKNNwKE3i',2,'\xe3782c213aa94a669059f8d7baad31fc',true);
INSERT INTO ROLES (id,role) VALUES(1,'ROLE_ADMIN');
INSERT INTO ROLES (id,role) VALUES(2,'ROLE_USER');


INSERT INTO USER_ROLES (user_id,role_id) VALUES (1,1);
INSERT INTO USER_ROLES (user_id,role_id) VALUES (1,2);
INSERT INTO USER_ROLES (user_id,role_id) VALUES (2,2);
INSERT INTO USER_ROLES (user_id,role_id) VALUES (3,2);

