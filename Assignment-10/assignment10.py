from random import randint
from flask import Flask, request, render_template
app = Flask(__name__)

@app.route('/', methods=['GET', 'POST'])
@app.route('/assignment10.html', methods=['GET', 'POST'])
def index():
	if request.method == 'POST':
		number = request.form['answer']
		guess = request.form['guess']
		if guess == number:
			return render_template('correct.html', number=number)

		return render_template('guess.html', first=request.args.get('first'), last=request.args.get('last'), number=number, guess=guess, failed=True)

	if request.args.get('first') and request.args.get('last'):
		return render_template('guess.html', first=request.args.get('first'), last=request.args.get('last'), number=randint(1, 5))

	return render_template('index.html')
