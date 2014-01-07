create table t3(
f3 int,
f4 int,
constraint fk2 foreign key (f4) references t1(f1) on delete set null)