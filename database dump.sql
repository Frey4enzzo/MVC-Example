--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.3
-- Dumped by pg_dump version 9.6.3

-- Started on 2017-07-28 17:20:49

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'SQL_ASCII';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 2140 (class 1262 OID 16571)
-- Dependencies: 2139
-- Name: test; Type: COMMENT; Schema: -; Owner: Frey
--

COMMENT ON DATABASE test IS 'juniortest';


--
-- TOC entry 1 (class 3079 OID 12387)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2142 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 186 (class 1259 OID 16619)
-- Name: department; Type: TABLE; Schema: public; Owner: Frey
--

CREATE TABLE department (
    id integer NOT NULL,
    name character varying(255)
);


ALTER TABLE department OWNER TO "Frey";

--
-- TOC entry 185 (class 1259 OID 16617)
-- Name: department_id_seq; Type: SEQUENCE; Schema: public; Owner: Frey
--

CREATE SEQUENCE department_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE department_id_seq OWNER TO "Frey";

--
-- TOC entry 2143 (class 0 OID 0)
-- Dependencies: 185
-- Name: department_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Frey
--

ALTER SEQUENCE department_id_seq OWNED BY department.id;


--
-- TOC entry 188 (class 1259 OID 16627)
-- Name: employee; Type: TABLE; Schema: public; Owner: Frey
--

CREATE TABLE employee (
    id integer NOT NULL,
    firstname character varying(50),
    lastname character varying(50),
    "position" character varying(255),
    department_id integer
);


ALTER TABLE employee OWNER TO "Frey";

--
-- TOC entry 187 (class 1259 OID 16625)
-- Name: employee_id_seq; Type: SEQUENCE; Schema: public; Owner: Frey
--

CREATE SEQUENCE employee_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE employee_id_seq OWNER TO "Frey";

--
-- TOC entry 2144 (class 0 OID 0)
-- Dependencies: 187
-- Name: employee_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Frey
--

ALTER SEQUENCE employee_id_seq OWNED BY employee.id;


--
-- TOC entry 2007 (class 2604 OID 16622)
-- Name: department id; Type: DEFAULT; Schema: public; Owner: Frey
--

ALTER TABLE ONLY department ALTER COLUMN id SET DEFAULT nextval('department_id_seq'::regclass);


--
-- TOC entry 2008 (class 2604 OID 16630)
-- Name: employee id; Type: DEFAULT; Schema: public; Owner: Frey
--

ALTER TABLE ONLY employee ALTER COLUMN id SET DEFAULT nextval('employee_id_seq'::regclass);


--
-- TOC entry 2132 (class 0 OID 16619)
-- Dependencies: 186
-- Data for Name: department; Type: TABLE DATA; Schema: public; Owner: Frey
--

COPY department (id, name) FROM stdin;
1	Руководители
2	Бухгалтерия
3	Экономика
4	ЖКХ
5	Безопасность
6	ИТ
7	Закупки
8	Соцразвитие
\.


--
-- TOC entry 2145 (class 0 OID 0)
-- Dependencies: 185
-- Name: department_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Frey
--

SELECT pg_catalog.setval('department_id_seq', 32, true);


--
-- TOC entry 2134 (class 0 OID 16627)
-- Dependencies: 188
-- Data for Name: employee; Type: TABLE DATA; Schema: public; Owner: Frey
--

COPY employee (id, firstname, lastname, "position", department_id) FROM stdin;
6	Иван	Иванов	Директор	1
7	Светлана	Иванова	Бухгалтер	2
8	Петр	Петров	Специалист	3
9	Евгения	Свиридова	Специалист	4
10	Андрей	Сидоров	Эксперт	4
11	Владимир	Барабулев	Менеджер	3
12	Анна	Молодцова	Бухгалтер	2
13	Сергей	Шпротов	Заместитель директора	1
14	Сергей	Дубов	Эксперт	5
15	Алексей	Алексеев	Системный администратор	6
1	Эддард	Старк	Инженер	6
2	Тирион	Ланнистер	Контрактный управляющий	7
3	Серсея	Ланнистер	Главный бухгалтер	2
4	Джон	Сноу	Начальник безопасности	5
5	Сэмвел	Тарли	Аналитик	5
16	Тормунд	ВеликаньяСмерть	Охранник	5
\.


--
-- TOC entry 2146 (class 0 OID 0)
-- Dependencies: 187
-- Name: employee_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Frey
--

SELECT pg_catalog.setval('employee_id_seq', 49, true);


--
-- TOC entry 2010 (class 2606 OID 16624)
-- Name: department department_pkey; Type: CONSTRAINT; Schema: public; Owner: Frey
--

ALTER TABLE ONLY department
    ADD CONSTRAINT department_pkey PRIMARY KEY (id);


--
-- TOC entry 2012 (class 2606 OID 16632)
-- Name: employee employee_pkey; Type: CONSTRAINT; Schema: public; Owner: Frey
--

ALTER TABLE ONLY employee
    ADD CONSTRAINT employee_pkey PRIMARY KEY (id);


--
-- TOC entry 2013 (class 2606 OID 16670)
-- Name: employee fkbejtwvg9bxus2mffsm3swj3u9; Type: FK CONSTRAINT; Schema: public; Owner: Frey
--

ALTER TABLE ONLY employee
    ADD CONSTRAINT fkbejtwvg9bxus2mffsm3swj3u9 FOREIGN KEY (department_id) REFERENCES department(id);


-- Completed on 2017-07-28 17:20:49

--
-- PostgreSQL database dump complete
--

