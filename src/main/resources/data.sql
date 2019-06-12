


insert into user(name,email_address)
values('hidagara', 'hidagara@gmail.com')

insert into company(name,abreviature,description)
values ('Apple', 'AAPL', 'IT Company')

insert into stock(name, company,price)
values('Simple Apple Stock', 'Apple', 188)

insert into stock_market(stock, price, company)
values ('Basic Stock', 158, 'Tesla')

insert into portfolio(user_id, stock_id, account_id)
SELECT user.id, stock.id, account.id
FROM user as user
INNER JOIN account as account
on user.id = account.user_id
INNER JOIN stock as stock
on stock.id = account.stock_id
WHERE user.name = 'roman';

select name
      ,email_address
from user

select name
      ,abreviature
      ,description
from company

select stock.name AS stock_name
      ,company.name as company_name
      ,stock.price  as  stock_price
from stock as stock
left join company as company
on stock.company = company.id


CREATE TRIGGER dbo.update_stock_market
ON dbo.stock
AFTER DELETE
AS
BEGIN
    SET NOCOUNT ON;

    DELETE FROM stock_market
    where deleted.id = stock_id

END

CREATE TRIGGER dbo.insert_stock_market
ON dbo.stock
AFTER INSERT
AS
BEGIN
    SET NOCOUNT ON;
    INSERT INTO stock_market(stock, price, company)
    select i.stock,i.price,i.company from inserted as i


END