-- Table: public.members

-- DROP TABLE IF EXISTS public.members;

CREATE TABLE IF NOT EXISTS public.members
(
    user_id character varying(50) COLLATE pg_catalog."default" NOT NULL,
    pw character(68) COLLATE pg_catalog."default" NOT NULL,
    active smallint NOT NULL,
    CONSTRAINT members_pkey PRIMARY KEY (user_id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.members
    OWNER to postgres;

GRANT ALL ON TABLE public.members TO postgres;

GRANT ALL ON TABLE public.members TO spring_boot_demo;
-- Index: idx_members_user_id

-- DROP INDEX IF EXISTS public.idx_members_user_id;

CREATE INDEX IF NOT EXISTS idx_members_user_id
    ON public.members USING btree
    (user_id COLLATE pg_catalog."default" ASC NULLS LAST)
    TABLESPACE pg_default;