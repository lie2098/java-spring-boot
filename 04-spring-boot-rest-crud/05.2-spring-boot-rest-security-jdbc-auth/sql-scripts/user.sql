-- Table: public.users

-- DROP TABLE IF EXISTS public.users;

CREATE TABLE IF NOT EXISTS public.users
(
    username character varying(50) COLLATE pg_catalog."default" NOT NULL,
    password character varying(68) COLLATE pg_catalog."default" NOT NULL,
    enabled smallint NOT NULL,
    CONSTRAINT users_pkey PRIMARY KEY (username)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.users
    OWNER to postgres;

GRANT ALL ON TABLE public.users TO postgres;

GRANT ALL ON TABLE public.users TO spring_boot_demo;
-- Index: idx_username

-- DROP INDEX IF EXISTS public.idx_username;

CREATE INDEX IF NOT EXISTS idx_username
    ON public.users USING btree
    (username COLLATE pg_catalog."default" ASC NULLS LAST)
    TABLESPACE pg_default;