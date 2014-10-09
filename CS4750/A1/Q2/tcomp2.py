#########################################################
##  CS 4750 (Fall 2014), Assignment #1, Question #2    ##
##   Script File Name: tcomp2.py                       ##
##       Student Name: Darwin Carrillo                 ##
##         Login Name: drc610                          ##
##              MUN #: 201153210                       ##
#########################################################

"""
Word Similarity Calculator
The following program compares the word similarities of two files
Author: Darwin Carrillo
CS4750
Natural Language Processing
Question 2
"""

import sys

"""
Parse through file and add each word to dictionary
"""
def wordBankBuilder(fileName):
	#open file
	data = open(fileName, "r")
	#Holds the words extracted from the 'string' argument
	word_Bank = []
  #temporarily holds a word for the wordBank
	temp_Word = ""

	#pasre through files line by line
	for line in data:
  	#Extracts the words from the 'string' argument
	  for x in line:
	    if x.isalpha() != True:
	      #add the word if it is not empty
	      #this accounts for possible sequences of non-letter characters
	      if temp_Word != "":
	        word_Bank.append(temp_Word)
	      temp_Word = ""
	    else:
	      temp_Word += x
	#add the word if the else condition is never met
	if temp_Word !="":
		word_Bank.append(temp_Word)

	return word_Bank

"""
Determine the similarityScore of two sets
"""
def similarityScore(xWB, yWB):
	#Convert Lists into sets
	xWB = set(xWB)
	yWB = set(yWB)

	#words unique for x and y
	uX = len(xWB - yWB) * 1.0
	uY = len(yWB - xWB) * 1.0

	#number of words in xWB and yWB
	nX = len(xWB) * 1.0
	nY = len(yWB) * 1.0

	# Sim(x,y) = 1.0 - ((uX+uY)/(nX+nY))
	simScore = 1.0 - ((uX+uY)/(nX+nY))
	return simScore

"""
Start Main Process
"""

#print script usage
if len(sys.argv) < 3 :
	print "Usage: python tcomp2.py [MASTERFILE] [[CompareFile1] [CompareFile2] ...]"

#create list without script as an item
fileNames = sys.argv[1::]

#construct master file's wordbank
masterFile = fileNames.pop(0)
masterWB = wordBankBuilder(masterFile)

#keep scores
scores = dict([])
#get scores of all files listed in command line argument
for f in fileNames:
	wb = wordBankBuilder(f)
	scores[f] = similarityScore(masterWB, wb)
	print "Sim('%s', '%s') = %.4f" % (masterFile, f, scores.get(f))

#print out file with max value
maxScore = max(scores, key=scores.get)
print "File most similar to %s is %s with a score of %.3f" % (masterFile, maxScore, scores.get(maxScore))
