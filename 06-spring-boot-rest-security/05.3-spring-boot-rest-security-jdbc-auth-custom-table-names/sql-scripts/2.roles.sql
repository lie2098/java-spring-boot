-- Table: public.roles

-- DROP TABLE IF EXISTS public.roles;

CREATE TABLE IF NOT EXISTS public.roles
(
    user_id character varying(50) COLLATE pg_catalog."default" NOT NULL,
    role character varying(50) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT roles_user_id_role_key UNIQUE (user_id, role),
    CONSTRAINT roles_user_id_fkey FOREIGN KEY (user_id)
        REFERENCES public.members (user_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.roles
    OWNER to postgres;

GRANT ALL ON TABLE public.roles TO postgres;

GRANT ALL ON TABLE public.roles TO spring_boot_demo;
-- Index: idx_roles_role

-- DROP INDEX IF EXISTS public.idx_roles_role;

CREATE INDEX IF NOT EXISTS idx_roles_role
    ON public.roles USING btree
    (role COLLATE pg_catalog."default" ASC NULLS LAST)
    TABLESPACE pg_default;
-- Index: idx_roles_user_id

-- DROP INDEX IF EXISTS public.idx_roles_user_id;

CREATE INDEX IF NOT EXISTS idx_roles_user_id
    ON public.roles USING btree
    (user_id COLLATE pg_catalog."default" ASC NULLS LAST)
    TABLESPACE pg_default;