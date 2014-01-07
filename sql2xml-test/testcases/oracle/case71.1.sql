create table t6(
f1 int primary key,
f2 int unique,
f3 int references t1(f1) on delete set null,
f4 int check(f4 > 1) 
);
