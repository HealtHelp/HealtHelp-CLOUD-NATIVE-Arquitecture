
CREATE TABLE public.users (
    id integer primary key NOT NULL,
    username character varying(100) NOT NULL,
    password character varying(100) NOT NULL,
    tenant_id integer,
    profile_id integer NOT NULL,
    email character varying(100) NOT NULL
);


INSERT INTO USERS (id,username,password,tenant_id,profile_id,email) VALUES(1,'admin','\xa1dd0fcc86d6b6517d6ac11c68844c88',1,1,'\xe3782c213aa94a669059f8d7baad31fc');
