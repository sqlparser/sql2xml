create table t2(
f3 int,
f4 int,
foreign key (f4) references t1(f1) on delete cascade);