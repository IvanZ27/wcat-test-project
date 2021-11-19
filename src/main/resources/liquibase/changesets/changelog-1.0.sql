--liquibase formatted sql

--changeset ivan.sch:211118-1 create filter_table

CREATE TABLE public.filter
(
    id bigint GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    filter_name character varying(255),
    criteria_id bigint,
    condition_id bigint,
    amount_value bigint,
    title_value character varying(255),
    date_value DATE,
    selection int,
    CONSTRAINT filter_pkey PRIMARY KEY (id)
);
insert into public.filter (id, filter_name, criteria_id, condition_id, amount_value, title_value,
                           date_value, selection) values (1, 'Filter 1', 1, 1, 24345, null, null, 1);
insert into public.filter (id, filter_name, criteria_id, condition_id, amount_value, title_value,
                           date_value, selection) values (2, 'Filter 2', 2, 8, null, 'Wisercat', null, 2);
insert into public.filter (id, filter_name, criteria_id, condition_id, amount_value, title_value,
                           date_value, selection) values (3, 'Filter 3', 2, 8, null, null, '2021-11-22', 3);

--changeset ivan.sch:211118-2 add data to filter_table

CREATE TABLE public.criteria
(
    criteria_id bigint GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    criteria_text character varying(255) UNIQUE,
    CONSTRAINT criteria_pkey PRIMARY KEY (criteria_id)
);
insert into public.criteria (criteria_id, criteria_text) values (1, 'Amount');
insert into public.criteria (criteria_id, criteria_text) values (2, 'Title');
insert into public.criteria (criteria_id, criteria_text) values (3, 'Date');


--changeset ivan.sch:211118-3 add data to filter_table

CREATE TABLE public.condition
(
    condition_id bigint GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    criteria_id bigint,
    condition_text character varying(255),

    CONSTRAINT condition_pkey PRIMARY KEY (condition_id)
);
insert into public.condition (condition_id, criteria_id, condition_text) values (1, 1, 'Less than');
insert into public.condition (condition_id, criteria_id, condition_text) values (2, 1, 'Less than or equal to');
insert into public.condition (condition_id, criteria_id, condition_text) values (3, 1, 'Greater than');
insert into public.condition (condition_id, criteria_id, condition_text) values (4, 1, 'Greater than or equal to');
insert into public.condition (condition_id, criteria_id, condition_text) values (5, 1, 'Equal to');
insert into public.condition (condition_id, criteria_id, condition_text) values (6, 1, 'Not equal to');
insert into public.condition (condition_id, criteria_id, condition_text) values (7, 2, 'Contains');
insert into public.condition (condition_id, criteria_id, condition_text) values (8, 2, 'Does not contain');
insert into public.condition (condition_id, criteria_id, condition_text) values (9, 2, 'Equals');
insert into public.condition (condition_id, criteria_id, condition_text) values (10, 3, 'Equal to');
insert into public.condition (condition_id, criteria_id, condition_text) values (11, 3, 'Before');
insert into public.condition (condition_id, criteria_id, condition_text) values (12, 3, 'On or before');
insert into public.condition (condition_id, criteria_id, condition_text) values (13, 3, 'After');
insert into public.condition (condition_id, criteria_id, condition_text) values (14, 3, 'On or after');