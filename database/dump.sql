--
-- PostgreSQL database dump
--

-- Dumped from database version 17rc1
-- Dumped by pg_dump version 17rc1

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: financia; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.financia (
    id_instituicao integer NOT NULL,
    id_projeto integer NOT NULL
);


ALTER TABLE public.financia OWNER TO postgres;

--
-- Name: instituicao; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.instituicao (
    id_instituicao integer NOT NULL,
    nome character varying(100) NOT NULL,
    tipo character varying(50),
    pais character varying(50)
);


ALTER TABLE public.instituicao OWNER TO postgres;

--
-- Name: instituicao_id_instituicao_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.instituicao_id_instituicao_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.instituicao_id_instituicao_seq OWNER TO postgres;

--
-- Name: instituicao_id_instituicao_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.instituicao_id_instituicao_seq OWNED BY public.instituicao.id_instituicao;


--
-- Name: orientando; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.orientando (
    id_orientando integer NOT NULL,
    nome character varying(100) NOT NULL,
    email character varying(100),
    nivel_academico character varying(50),
    id_projeto integer NOT NULL
);


ALTER TABLE public.orientando OWNER TO postgres;

--
-- Name: orientando_id_orientando_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.orientando_id_orientando_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.orientando_id_orientando_seq OWNER TO postgres;

--
-- Name: orientando_id_orientando_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.orientando_id_orientando_seq OWNED BY public.orientando.id_orientando;


--
-- Name: participa_projeto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.participa_projeto (
    id_pesquisador integer NOT NULL,
    id_projeto integer NOT NULL,
    papel character varying(50)
);


ALTER TABLE public.participa_projeto OWNER TO postgres;

--
-- Name: pesquisador; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pesquisador (
    id_pesquisador integer NOT NULL,
    nome character varying(100) NOT NULL,
    email character varying(100) NOT NULL,
    instituicao character varying(100)
);


ALTER TABLE public.pesquisador OWNER TO postgres;

--
-- Name: pesquisador_id_pesquisador_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.pesquisador_id_pesquisador_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.pesquisador_id_pesquisador_seq OWNER TO postgres;

--
-- Name: pesquisador_id_pesquisador_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.pesquisador_id_pesquisador_seq OWNED BY public.pesquisador.id_pesquisador;


--
-- Name: projeto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.projeto (
    id_projeto integer NOT NULL,
    id_coordenador integer,
    id_instituicao integer,
    titulo character varying(150) NOT NULL,
    area_pesquisa character varying(100),
    data_inicio date,
    data_fim date
);


ALTER TABLE public.projeto OWNER TO postgres;

--
-- Name: projeto_id_projeto_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.projeto_id_projeto_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.projeto_id_projeto_seq OWNER TO postgres;

--
-- Name: projeto_id_projeto_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.projeto_id_projeto_seq OWNED BY public.projeto.id_projeto;


--
-- Name: publicacao; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.publicacao (
    id_publicacao integer NOT NULL,
    id_projeto integer NOT NULL,
    titulo character varying(150) NOT NULL,
    tipo character varying(50),
    data_publicacao date,
    doi character varying(100)
);


ALTER TABLE public.publicacao OWNER TO postgres;

--
-- Name: publicacao_id_publicacao_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.publicacao_id_publicacao_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.publicacao_id_publicacao_seq OWNER TO postgres;

--
-- Name: publicacao_id_publicacao_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.publicacao_id_publicacao_seq OWNED BY public.publicacao.id_publicacao;


--
-- Name: instituicao id_instituicao; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.instituicao ALTER COLUMN id_instituicao SET DEFAULT nextval('public.instituicao_id_instituicao_seq'::regclass);


--
-- Name: orientando id_orientando; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orientando ALTER COLUMN id_orientando SET DEFAULT nextval('public.orientando_id_orientando_seq'::regclass);


--
-- Name: pesquisador id_pesquisador; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pesquisador ALTER COLUMN id_pesquisador SET DEFAULT nextval('public.pesquisador_id_pesquisador_seq'::regclass);


--
-- Name: projeto id_projeto; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.projeto ALTER COLUMN id_projeto SET DEFAULT nextval('public.projeto_id_projeto_seq'::regclass);


--
-- Name: publicacao id_publicacao; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.publicacao ALTER COLUMN id_publicacao SET DEFAULT nextval('public.publicacao_id_publicacao_seq'::regclass);


--
-- Data for Name: financia; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.financia (id_instituicao, id_projeto) VALUES (2, 2);
INSERT INTO public.financia (id_instituicao, id_projeto) VALUES (3, 3);
INSERT INTO public.financia (id_instituicao, id_projeto) VALUES (1, 3);


--
-- Data for Name: instituicao; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.instituicao (id_instituicao, nome, tipo, pais) VALUES (1, 'Universidade de São Paulo', 'Universidade', 'Brasil');
INSERT INTO public.instituicao (id_instituicao, nome, tipo, pais) VALUES (2, 'Instituto Nacional de Pesquisas Espaciais', 'Instituto', 'Brasil');
INSERT INTO public.instituicao (id_instituicao, nome, tipo, pais) VALUES (3, 'Massachusetts Institute of Technology', 'Universidade', 'EUA');


--
-- Data for Name: orientando; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.orientando (id_orientando, nome, email, nivel_academico, id_projeto) VALUES (1, 'Lucas Fernandes', 'lucas.fernandes@aluno.usp.br', 'Mestrado', 1);
INSERT INTO public.orientando (id_orientando, nome, email, nivel_academico, id_projeto) VALUES (2, 'Carla Borges', 'carla.borges@aluno.inpe.br', 'Doutorado', 2);
INSERT INTO public.orientando (id_orientando, nome, email, nivel_academico, id_projeto) VALUES (3, 'Felipe Souza', 'felipe.souza@aluno.mit.edu', 'Graduação', 3);


--
-- Data for Name: participa_projeto; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.participa_projeto (id_pesquisador, id_projeto, papel) VALUES (1, 1, 'Coordenador');
INSERT INTO public.participa_projeto (id_pesquisador, id_projeto, papel) VALUES (2, 1, 'Pesquisador Convidado');
INSERT INTO public.participa_projeto (id_pesquisador, id_projeto, papel) VALUES (2, 2, 'Coordenador');
INSERT INTO public.participa_projeto (id_pesquisador, id_projeto, papel) VALUES (3, 2, 'Pesquisador Convidado');
INSERT INTO public.participa_projeto (id_pesquisador, id_projeto, papel) VALUES (3, 3, 'Coordenador');


--
-- Data for Name: pesquisador; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.pesquisador (id_pesquisador, nome, email, instituicao) VALUES (1, 'Dra. Ana Paula Mendes', 'ana.mendes@usp.br', 'Universidade de São Paulo');
INSERT INTO public.pesquisador (id_pesquisador, nome, email, instituicao) VALUES (2, 'Dr. Carlos Silva', 'carlos.silva@inpe.br', 'Instituto Nacional de Pesquisas Espaciais');
INSERT INTO public.pesquisador (id_pesquisador, nome, email, instituicao) VALUES (3, 'Dr. Julia Hart', 'julia.hart@mit.edu', 'Massachusetts Institute of Technology');


--
-- Data for Name: projeto; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.projeto (id_projeto, id_coordenador, id_instituicao, titulo, area_pesquisa, data_inicio, data_fim) VALUES (1, 1, 1, 'Análise de Dados Genômicos', 'Bioinformática', '2023-01-10', '2024-12-15');
INSERT INTO public.projeto (id_projeto, id_coordenador, id_instituicao, titulo, area_pesquisa, data_inicio, data_fim) VALUES (2, 2, 2, 'Otimização de Redes Neurais', 'Inteligência Artificial', '2022-08-01', '2025-01-30');
INSERT INTO public.projeto (id_projeto, id_coordenador, id_instituicao, titulo, area_pesquisa, data_inicio, data_fim) VALUES (3, 3, 3, 'Sustentabilidade Urbana com IoT', 'Tecnologia Ambiental', '2024-03-15', '2026-03-14');


--
-- Data for Name: publicacao; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.publicacao (id_publicacao, id_projeto, titulo, tipo, data_publicacao, doi) VALUES (1, 1, 'Métodos de Clusterização em Genômica', 'Artigo Científico', '2024-01-10', '10.1234/genomics.001');
INSERT INTO public.publicacao (id_publicacao, id_projeto, titulo, tipo, data_publicacao, doi) VALUES (2, 2, 'Redes Neurais Profundas em Ambientes Reais', 'Conferência', '2023-11-20', '10.1234/ia.002');
INSERT INTO public.publicacao (id_publicacao, id_projeto, titulo, tipo, data_publicacao, doi) VALUES (3, 3, 'Cidades Inteligentes com IoT Sustentável', 'Artigo Científico', '2025-05-06', '10.1234/iot.003');


--
-- Name: instituicao_id_instituicao_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.instituicao_id_instituicao_seq', 3, true);


--
-- Name: orientando_id_orientando_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.orientando_id_orientando_seq', 3, true);


--
-- Name: pesquisador_id_pesquisador_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.pesquisador_id_pesquisador_seq', 3, true);


--
-- Name: projeto_id_projeto_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.projeto_id_projeto_seq', 3, true);


--
-- Name: publicacao_id_publicacao_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.publicacao_id_publicacao_seq', 3, true);


--
-- Name: financia financia_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.financia
    ADD CONSTRAINT financia_pkey PRIMARY KEY (id_instituicao, id_projeto);


--
-- Name: instituicao instituicao_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.instituicao
    ADD CONSTRAINT instituicao_pkey PRIMARY KEY (id_instituicao);


--
-- Name: orientando orientando_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orientando
    ADD CONSTRAINT orientando_pkey PRIMARY KEY (id_orientando);


--
-- Name: participa_projeto participa_projeto_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.participa_projeto
    ADD CONSTRAINT participa_projeto_pkey PRIMARY KEY (id_pesquisador, id_projeto);


--
-- Name: pesquisador pesquisador_email_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pesquisador
    ADD CONSTRAINT pesquisador_email_key UNIQUE (email);


--
-- Name: pesquisador pesquisador_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pesquisador
    ADD CONSTRAINT pesquisador_pkey PRIMARY KEY (id_pesquisador);


--
-- Name: projeto projeto_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.projeto
    ADD CONSTRAINT projeto_pkey PRIMARY KEY (id_projeto);


--
-- Name: publicacao publicacao_doi_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.publicacao
    ADD CONSTRAINT publicacao_doi_key UNIQUE (doi);


--
-- Name: publicacao publicacao_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.publicacao
    ADD CONSTRAINT publicacao_pkey PRIMARY KEY (id_publicacao);


--
-- Name: financia financia_id_instituicao_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.financia
    ADD CONSTRAINT financia_id_instituicao_fkey FOREIGN KEY (id_instituicao) REFERENCES public.instituicao(id_instituicao);


--
-- Name: financia financia_id_projeto_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.financia
    ADD CONSTRAINT financia_id_projeto_fkey FOREIGN KEY (id_projeto) REFERENCES public.projeto(id_projeto);


--
-- Name: orientando orientando_id_projeto_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orientando
    ADD CONSTRAINT orientando_id_projeto_fkey FOREIGN KEY (id_projeto) REFERENCES public.projeto(id_projeto);


--
-- Name: participa_projeto participa_projeto_id_pesquisador_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.participa_projeto
    ADD CONSTRAINT participa_projeto_id_pesquisador_fkey FOREIGN KEY (id_pesquisador) REFERENCES public.pesquisador(id_pesquisador);


--
-- Name: participa_projeto participa_projeto_id_projeto_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.participa_projeto
    ADD CONSTRAINT participa_projeto_id_projeto_fkey FOREIGN KEY (id_projeto) REFERENCES public.projeto(id_projeto);


--
-- Name: projeto projeto_id_coordenador_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.projeto
    ADD CONSTRAINT projeto_id_coordenador_fkey FOREIGN KEY (id_coordenador) REFERENCES public.pesquisador(id_pesquisador);


--
-- Name: projeto projeto_id_instituicao_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.projeto
    ADD CONSTRAINT projeto_id_instituicao_fkey FOREIGN KEY (id_instituicao) REFERENCES public.instituicao(id_instituicao);


--
-- Name: publicacao publicacao_id_projeto_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.publicacao
    ADD CONSTRAINT publicacao_id_projeto_fkey FOREIGN KEY (id_projeto) REFERENCES public.projeto(id_projeto);


--
-- PostgreSQL database dump complete
--

