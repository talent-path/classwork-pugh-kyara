--
-- PostgreSQL database dump
--

-- Dumped from database version 13.1
-- Dumped by pg_dump version 13.1

-- Started on 2021-02-04 11:22:24 EST

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

DROP DATABASE "Restaurant";
--
-- TOC entry 3346 (class 1262 OID 16424)
-- Name: Restaurant; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE "Restaurant" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'C';


ALTER DATABASE "Restaurant" OWNER TO "postgres";

\connect "Restaurant"

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 3347 (class 0 OID 0)
-- Dependencies: 3346
-- Name: DATABASE "Restaurant"; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON DATABASE "Restaurant" IS 'restaurant db project';


SET default_tablespace = '';

SET default_table_access_method = "heap";

--
-- TOC entry 201 (class 1259 OID 16427)
-- Name: Dishes; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "public"."Dishes" (
    "dishID" integer NOT NULL,
    "name" character varying(50) NOT NULL
);


ALTER TABLE "public"."Dishes" OWNER TO "postgres";

--
-- TOC entry 200 (class 1259 OID 16425)
-- Name: Dishes_dishID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE "public"."Dishes_dishID_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "public"."Dishes_dishID_seq" OWNER TO "postgres";

--
-- TOC entry 3348 (class 0 OID 0)
-- Dependencies: 200
-- Name: Dishes_dishID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "public"."Dishes_dishID_seq" OWNED BY "public"."Dishes"."dishID";


--
-- TOC entry 203 (class 1259 OID 16435)
-- Name: Ingredients; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "public"."Ingredients" (
    "ingredientID" integer NOT NULL,
    "name" character varying(50) NOT NULL,
    "stock" integer,
    "units" numeric
);


ALTER TABLE "public"."Ingredients" OWNER TO "postgres";

--
-- TOC entry 202 (class 1259 OID 16433)
-- Name: Ingredients_ingredientID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE "public"."Ingredients_ingredientID_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "public"."Ingredients_ingredientID_seq" OWNER TO "postgres";

--
-- TOC entry 3349 (class 0 OID 0)
-- Dependencies: 202
-- Name: Ingredients_ingredientID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "public"."Ingredients_ingredientID_seq" OWNED BY "public"."Ingredients"."ingredientID";


--
-- TOC entry 207 (class 1259 OID 16460)
-- Name: Menu; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "public"."Menu" (
    "menuID" integer NOT NULL,
    "name" character varying(100) NOT NULL
);


ALTER TABLE "public"."Menu" OWNER TO "postgres";

--
-- TOC entry 210 (class 1259 OID 16474)
-- Name: MenuDishes; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "public"."MenuDishes" (
    "menuID" integer,
    "dishID" integer,
    "price" numeric NOT NULL
);


ALTER TABLE "public"."MenuDishes" OWNER TO "postgres";

--
-- TOC entry 206 (class 1259 OID 16458)
-- Name: Menu_menuID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE "public"."Menu_menuID_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "public"."Menu_menuID_seq" OWNER TO "postgres";

--
-- TOC entry 3350 (class 0 OID 0)
-- Dependencies: 206
-- Name: Menu_menuID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "public"."Menu_menuID_seq" OWNED BY "public"."Menu"."menuID";


--
-- TOC entry 217 (class 1259 OID 16557)
-- Name: OrderDishes; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "public"."OrderDishes" (
    "orderID" integer NOT NULL,
    "dishID" integer NOT NULL,
    "menuID" integer NOT NULL,
    "quantity" numeric NOT NULL
);


ALTER TABLE "public"."OrderDishes" OWNER TO "postgres";

--
-- TOC entry 213 (class 1259 OID 16520)
-- Name: Orders; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "public"."Orders" (
    "orderID" integer NOT NULL,
    "tableID" integer NOT NULL
);


ALTER TABLE "public"."Orders" OWNER TO "postgres";

--
-- TOC entry 212 (class 1259 OID 16518)
-- Name: Orders_orderID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE "public"."Orders_orderID_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "public"."Orders_orderID_seq" OWNER TO "postgres";

--
-- TOC entry 3351 (class 0 OID 0)
-- Dependencies: 212
-- Name: Orders_orderID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "public"."Orders_orderID_seq" OWNED BY "public"."Orders"."orderID";


--
-- TOC entry 211 (class 1259 OID 16500)
-- Name: RecipeIngredients; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "public"."RecipeIngredients" (
    "recipeID" integer NOT NULL,
    "ingredientID" integer NOT NULL,
    "quantity" numeric NOT NULL,
    "unit" character varying NOT NULL
);


ALTER TABLE "public"."RecipeIngredients" OWNER TO "postgres";

--
-- TOC entry 205 (class 1259 OID 16446)
-- Name: Recipes; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "public"."Recipes" (
    "recipeID" integer NOT NULL,
    "dishID" integer NOT NULL,
    "name" character varying(50) NOT NULL,
    "instructions" "text" NOT NULL
);


ALTER TABLE "public"."Recipes" OWNER TO "postgres";

--
-- TOC entry 204 (class 1259 OID 16444)
-- Name: Recipes_recipeID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE "public"."Recipes_recipeID_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "public"."Recipes_recipeID_seq" OWNER TO "postgres";

--
-- TOC entry 3352 (class 0 OID 0)
-- Dependencies: 204
-- Name: Recipes_recipeID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "public"."Recipes_recipeID_seq" OWNED BY "public"."Recipes"."recipeID";


--
-- TOC entry 215 (class 1259 OID 16533)
-- Name: Supplier; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "public"."Supplier" (
    "supplierID" integer NOT NULL,
    "name" character varying(50) NOT NULL
);


ALTER TABLE "public"."Supplier" OWNER TO "postgres";

--
-- TOC entry 216 (class 1259 OID 16539)
-- Name: SupplierIngredients; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "public"."SupplierIngredients" (
    "supplierID" integer NOT NULL,
    "ingredientID" integer NOT NULL,
    "quantity" numeric,
    "units" character varying(50),
    "price" numeric NOT NULL
);


ALTER TABLE "public"."SupplierIngredients" OWNER TO "postgres";

--
-- TOC entry 214 (class 1259 OID 16531)
-- Name: Supplier_supplierID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE "public"."Supplier_supplierID_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "public"."Supplier_supplierID_seq" OWNER TO "postgres";

--
-- TOC entry 3353 (class 0 OID 0)
-- Dependencies: 214
-- Name: Supplier_supplierID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "public"."Supplier_supplierID_seq" OWNED BY "public"."Supplier"."supplierID";


--
-- TOC entry 209 (class 1259 OID 16468)
-- Name: TableTops; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "public"."TableTops" (
    "tableID" integer NOT NULL,
    "seats" integer NOT NULL
);


ALTER TABLE "public"."TableTops" OWNER TO "postgres";

--
-- TOC entry 208 (class 1259 OID 16466)
-- Name: TableTops_tableID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE "public"."TableTops_tableID_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "public"."TableTops_tableID_seq" OWNER TO "postgres";

--
-- TOC entry 3354 (class 0 OID 0)
-- Dependencies: 208
-- Name: TableTops_tableID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "public"."TableTops_tableID_seq" OWNED BY "public"."TableTops"."tableID";


--
-- TOC entry 3173 (class 2604 OID 16430)
-- Name: Dishes dishID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "public"."Dishes" ALTER COLUMN "dishID" SET DEFAULT "nextval"('"public"."Dishes_dishID_seq"'::"regclass");


--
-- TOC entry 3174 (class 2604 OID 16438)
-- Name: Ingredients ingredientID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "public"."Ingredients" ALTER COLUMN "ingredientID" SET DEFAULT "nextval"('"public"."Ingredients_ingredientID_seq"'::"regclass");


--
-- TOC entry 3176 (class 2604 OID 16463)
-- Name: Menu menuID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "public"."Menu" ALTER COLUMN "menuID" SET DEFAULT "nextval"('"public"."Menu_menuID_seq"'::"regclass");


--
-- TOC entry 3178 (class 2604 OID 16523)
-- Name: Orders orderID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "public"."Orders" ALTER COLUMN "orderID" SET DEFAULT "nextval"('"public"."Orders_orderID_seq"'::"regclass");


--
-- TOC entry 3175 (class 2604 OID 16449)
-- Name: Recipes recipeID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "public"."Recipes" ALTER COLUMN "recipeID" SET DEFAULT "nextval"('"public"."Recipes_recipeID_seq"'::"regclass");


--
-- TOC entry 3179 (class 2604 OID 16536)
-- Name: Supplier supplierID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "public"."Supplier" ALTER COLUMN "supplierID" SET DEFAULT "nextval"('"public"."Supplier_supplierID_seq"'::"regclass");


--
-- TOC entry 3177 (class 2604 OID 16471)
-- Name: TableTops tableID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "public"."TableTops" ALTER COLUMN "tableID" SET DEFAULT "nextval"('"public"."TableTops_tableID_seq"'::"regclass");


--
-- TOC entry 3181 (class 2606 OID 16432)
-- Name: Dishes Dishes_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "public"."Dishes"
    ADD CONSTRAINT "Dishes_pkey" PRIMARY KEY ("dishID");


--
-- TOC entry 3183 (class 2606 OID 16443)
-- Name: Ingredients Ingredients_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "public"."Ingredients"
    ADD CONSTRAINT "Ingredients_pkey" PRIMARY KEY ("ingredientID");


--
-- TOC entry 3187 (class 2606 OID 16465)
-- Name: Menu Menu_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "public"."Menu"
    ADD CONSTRAINT "Menu_pkey" PRIMARY KEY ("menuID");


--
-- TOC entry 3199 (class 2606 OID 16564)
-- Name: OrderDishes OrderDishes_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "public"."OrderDishes"
    ADD CONSTRAINT "OrderDishes_pkey" PRIMARY KEY ("orderID", "dishID", "menuID");


--
-- TOC entry 3193 (class 2606 OID 16525)
-- Name: Orders Orders_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "public"."Orders"
    ADD CONSTRAINT "Orders_pkey" PRIMARY KEY ("orderID");


--
-- TOC entry 3191 (class 2606 OID 16507)
-- Name: RecipeIngredients RecipeIngredients_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "public"."RecipeIngredients"
    ADD CONSTRAINT "RecipeIngredients_pkey" PRIMARY KEY ("recipeID", "ingredientID");


--
-- TOC entry 3185 (class 2606 OID 16499)
-- Name: Recipes Recipes_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "public"."Recipes"
    ADD CONSTRAINT "Recipes_pkey" PRIMARY KEY ("recipeID");


--
-- TOC entry 3197 (class 2606 OID 16546)
-- Name: SupplierIngredients SupplierIngredients_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "public"."SupplierIngredients"
    ADD CONSTRAINT "SupplierIngredients_pkey" PRIMARY KEY ("supplierID", "ingredientID");


--
-- TOC entry 3195 (class 2606 OID 16538)
-- Name: Supplier Supplier_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "public"."Supplier"
    ADD CONSTRAINT "Supplier_pkey" PRIMARY KEY ("supplierID");


--
-- TOC entry 3189 (class 2606 OID 16473)
-- Name: TableTops TableTops_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "public"."TableTops"
    ADD CONSTRAINT "TableTops_pkey" PRIMARY KEY ("tableID");


--
-- TOC entry 3209 (class 2606 OID 16570)
-- Name: OrderDishes OrderDishes_dishID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "public"."OrderDishes"
    ADD CONSTRAINT "OrderDishes_dishID_fkey" FOREIGN KEY ("dishID") REFERENCES "public"."Dishes"("dishID");


--
-- TOC entry 3210 (class 2606 OID 16575)
-- Name: OrderDishes OrderDishes_menuID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "public"."OrderDishes"
    ADD CONSTRAINT "OrderDishes_menuID_fkey" FOREIGN KEY ("menuID") REFERENCES "public"."Menu"("menuID");


--
-- TOC entry 3208 (class 2606 OID 16565)
-- Name: OrderDishes OrderDishes_orderID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "public"."OrderDishes"
    ADD CONSTRAINT "OrderDishes_orderID_fkey" FOREIGN KEY ("orderID") REFERENCES "public"."Orders"("orderID");


--
-- TOC entry 3205 (class 2606 OID 16526)
-- Name: Orders Orders_tableID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "public"."Orders"
    ADD CONSTRAINT "Orders_tableID_fkey" FOREIGN KEY ("tableID") REFERENCES "public"."TableTops"("tableID");


--
-- TOC entry 3204 (class 2606 OID 16513)
-- Name: RecipeIngredients RecipeIngredients_ingredientID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "public"."RecipeIngredients"
    ADD CONSTRAINT "RecipeIngredients_ingredientID_fkey" FOREIGN KEY ("ingredientID") REFERENCES "public"."Ingredients"("ingredientID");


--
-- TOC entry 3203 (class 2606 OID 16508)
-- Name: RecipeIngredients RecipeIngredients_recipeID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "public"."RecipeIngredients"
    ADD CONSTRAINT "RecipeIngredients_recipeID_fkey" FOREIGN KEY ("recipeID") REFERENCES "public"."Recipes"("recipeID");


--
-- TOC entry 3200 (class 2606 OID 16453)
-- Name: Recipes Recipes_dishID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "public"."Recipes"
    ADD CONSTRAINT "Recipes_dishID_fkey" FOREIGN KEY ("dishID") REFERENCES "public"."Dishes"("dishID");


--
-- TOC entry 3207 (class 2606 OID 16552)
-- Name: SupplierIngredients SupplierIngredients_ingredientID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "public"."SupplierIngredients"
    ADD CONSTRAINT "SupplierIngredients_ingredientID_fkey" FOREIGN KEY ("ingredientID") REFERENCES "public"."Ingredients"("ingredientID");


--
-- TOC entry 3206 (class 2606 OID 16547)
-- Name: SupplierIngredients SupplierIngredients_supplierID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "public"."SupplierIngredients"
    ADD CONSTRAINT "SupplierIngredients_supplierID_fkey" FOREIGN KEY ("supplierID") REFERENCES "public"."Supplier"("supplierID");


--
-- TOC entry 3201 (class 2606 OID 16480)
-- Name: MenuDishes f_key1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "public"."MenuDishes"
    ADD CONSTRAINT "f_key1" FOREIGN KEY ("menuID") REFERENCES "public"."Menu"("menuID");


--
-- TOC entry 3202 (class 2606 OID 16485)
-- Name: MenuDishes f_key2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "public"."MenuDishes"
    ADD CONSTRAINT "f_key2" FOREIGN KEY ("dishID") REFERENCES "public"."Dishes"("dishID");


-- Completed on 2021-02-04 11:22:24 EST

--
-- PostgreSQL database dump complete
--

