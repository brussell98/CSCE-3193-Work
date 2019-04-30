from flask import Flask, request, render_template, session

accounts = { }

def readAccounts():
	file = open('./assignment11-account-info.txt', 'r')
	accs = [acc.split(';') for acc in file.readlines()]
	for acc in accs:
		accounts[acc[0]] = {
			'user': acc[0],
			'pass': acc[1],
			'first': acc[2],
			'last': acc[3],
			'color': acc[4],
			'title': acc[5],
			'avatarUrl': acc[6].rstrip()
		}
	file.close()

# def addAccount(user):
# 	accounts[user['user']] = {
# 		'user': user['user'],
# 		'pass': user['pass'],
# 		'first': user['first'],
# 		'last': user['last'],
# 		'color': user['color'],
# 		'title': user['title'],
# 		'avatarUrl': user['avatarUrl']
# 	}

def saveUsers():
	text = ''
	for _, acc in accounts.items():
		text += ';'.join([str(x) for x in acc.values()]) + '\n'
	with open('./assignment11-account-info.txt', 'w') as file:
		file.write(text)

readAccounts()

app = Flask(__name__)

app.secret_key = b'jrsydjfhjbuymt'

@app.route('/')
@app.route('/assignment11.html')
def index():
	return render_template('index.html')
