create sequence client_id_seq
  start with 1
  increment by 1
  maxvalue 99999
  minvalue 1;
  
  create sequence client_afp_id_seq
  start with 1
  increment by 1
  maxvalue 99999
  minvalue 1;
  
  create sequence afp_id_seq
  start with 1
  increment by 1
  maxvalue 99999
  minvalue 1;
  
  create sequence client_account_id_seq
  start with 1
  increment by 1
  maxvalue 99999
  minvalue 1;
  
  create sequence client_request_id_seq
  start with 1
  increment by 1
  maxvalue 99999
  minvalue 1;
  

CREATE TABLE IF NOT EXISTS client
(
    id bigint NOT NULL DEFAULT nextval('client_id_seq'::regclass),
    dni character varying(25) NOT NULL,
    name character varying(255),
    lastname character varying(255),
    phone character varying(50),
    email character varying(255),
    CONSTRAINT client_pkey PRIMARY KEY (id),
    UNIQUE (dni)
);



CREATE TABLE IF NOT EXISTS  public.afp
(
    id bigint NOT NULL DEFAULT nextval('afp_id_seq'::regclass),
    name character varying(255),
    CONSTRAINT afp_pkey PRIMARY KEY (id),
    UNIQUE(name)
);

CREATE TABLE IF NOT EXISTS  public.client_afp
(
    id bigint NOT NULL DEFAULT nextval('client_afp_id_seq'::regclass),
    client_id BIGINT NOT NULL,
    afp_id BIGINT NOT NULL,
    CONSTRAINT client_afp_pkey PRIMARY KEY (id),
    UNIQUE(client_id)
);

CREATE TABLE IF NOT EXISTS  public.client_account
(
    id bigint NOT NULL DEFAULT nextval('client_account_id_seq'::regclass),
    client_afp_id BIGINT NOT NULL,
    amount FLOAT NOT NULL,
    retire_date date,
    account character varying(255),
    CONSTRAINT client_account_pkey PRIMARY KEY (id),
    UNIQUE(client_afp_id)
)

CREATE TABLE IF NOT EXISTS public.client_request
(
    id bigint NOT NULL DEFAULT nextval('client_request_id_seq'::regclass),
    client_account_id bigint not null,
    amount float,
    CONSTRAINT client_request_pkey PRIMARY KEY (id)
);

