-- Table: public.authorities

-- DROP TABLE IF EXISTS public.authorities;

CREATE TABLE IF NOT EXISTS public.authorities
(
    username character varying(50) COLLATE pg_catalog."default" NOT NULL,
    authority character varying(50) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT authorities_username_authority_key UNIQUE (username, authority),
    CONSTRAINT authorities_username_fkey FOREIGN KEY (username)
        REFERENCES public.users (username) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.authorities
    OWNER to postgres;

GRANT ALL ON TABLE public.authorities TO postgres;

GRANT ALL ON TABLE public.authorities TO spring_boot_demo;
-- Index: idx_authority

-- DROP INDEX IF EXISTS public.idx_authority;

CREATE INDEX IF NOT EXISTS idx_authority
    ON public.authorities USING btree
    (authority COLLATE pg_catalog."default" ASC NULLS LAST)
    TABLESPACE pg_default;
-- Index: idx_username_authority

-- DROP INDEX IF EXISTS public.idx_username_authority;

CREATE INDEX IF NOT EXISTS idx_username_authority
    ON public.authorities USING btree
    (username COLLATE pg_catalog."default" ASC NULLS LAST, authority COLLATE pg_catalog."default" ASC NULLS LAST)
    TABLESPACE pg_default;