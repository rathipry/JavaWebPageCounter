create database counterDB;

use counterDB;

create table tbl_pagecount(count int not null);
        
insert into tbl_pagecount(count) value(0);        
        
select * from tbl_pagecount;       
