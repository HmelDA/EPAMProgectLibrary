-- DDL


-- Table: public.Clients

-- DROP TABLE IF EXISTS public.Clients;

CREATE TABLE IF NOT EXISTS public."Clients" (
    ID          serial NOT NULL PRIMARY KEY,
    firstName   varchar(20) NOT NULL,
    lastName    varchar(20)  NOT NULL
    --CONSTRAINT  CPK PRIMARY KEY (ID)
    );

-- Table: public.Books

-- DROP TABLE IF EXISTS public.Books;

CREATE TABLE IF NOT EXISTS public."Books" (
    ID         serial NOT NULL PRIMARY KEY,
    bookname   varchar(100) NOT NULL,
    author     varchar(50) NOT NULL,
    genre      varchar(50) NOT NULL,
    presense   boolean default true
    --CONSTRAINT BPK PRIMARY KEY (ID)
    );

-- Table: public.Order

-- DROP TABLE IF EXISTS public."Orders";

CREATE TABLE IF NOT EXISTS public."Orders" (
    ID          serial NOT NULL PRIMARY KEY,
    clientID    integer NOT NULL,
    clientName  varchar(50) NOT NULL,
    bookOne     varchar(100),
    bookTwo     varchar(100),
    bookThree   varchar(100),
    confirmed   boolean default false
    --CONSTRAINT  OPK PRIMARY KEY (ID)
    );

COMMIT;