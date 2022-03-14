import relatorios as rl
import psycopg2

#Gerando conexão e bamco de dados padrão
conn = rl.conn                         


with open("tabelas.sql") as arquivo:
    conn.execute(arquivo.read())

print('Neste ponto, as tabelas ORÇAMENTO e INVEST(COMPRA & VENDA) foi criada com sucesso.')


conn.execute("insert into orcamento (descricao, preco) values ('mercado','10,00');")
print('Item adicionado com sucesso no orçamento')

conn.execute("insert into compra (classe, ativo, quant, preco) values ('acoes','abcd3','2000','1,00');")
print('Compra registrada')

conn.execute("insert into venda (classe, ativo, quant, preco) values ('acoes','abcd3','2000','10,00');")
print('Venda registrada')

conn.execute("insert into proventos (classe, ativo, quant, valor) values ('acoes','abcd3','2000','10,00');")
print('proventos registrada')

conn.execute("insert into agenda (organizacao, identidade, senha, observacoes) values ('banco local SA','23XX','@123456789abcd#$%!@&*','conta corrent 23XX 1 agencia 00');")
print('agenda registrada')

arquivo.close()
rl.session.commit()
rl.session.close()
