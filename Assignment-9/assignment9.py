import sys
import re
import operator

if len(sys.argv) < 3:
	if len(sys.argv) < 2:
		print('Missing required argument: story')
	print('Missing required argument: skip words')
	print('Usage: assignment9.py <story> <skip words>')
	exit(0)

with open(sys.argv[1], 'r') as storyFile:
	story = [re.sub(r'\n|\t|\.|\?|!|,|;|:|\'|"', '', s.lower()).strip() for s in storyFile.readlines()]

with open(sys.argv[2], 'r') as skipFile:
	skipWords = skipFile.readline().split(',')

wordList = []
for line in story:
	if not line:
		continue
	wordList.extend([word for word in line.split(' ') if word and word not in skipWords])

wordPairs = { }
for i in range(len(wordList) - 1):
	key = '{} {}'.format(wordList[i], wordList[i + 1])
	wordPairs[key] = wordPairs[key] + 1 if key in wordPairs else 1

print('Five most frequently occuring word pairs:')
wordPairs = sorted(wordPairs.items(), key=operator.itemgetter(1), reverse=True)
for i in range(5):
	print(wordPairs[i])
