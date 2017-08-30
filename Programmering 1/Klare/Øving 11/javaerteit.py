with open('saldo.txt', 'rw') as balance:
	b = float(balance.readline())
	with open('t', 'r') as transaction:
		for line in transaction:
			print(line)
