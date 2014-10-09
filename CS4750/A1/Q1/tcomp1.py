#########################################################
##  CS 4750 (Fall 2014), Assignment #1, Question #1    ##
##   Script File Name: tcomp1.py                       ##
##       Student Name: Darwin Carrillo                 ##
##         Login Name: drc610                          ##
##              MUN #: 201153210                       ##
#########################################################

"""
N-Gram Similarity Calculator
Author: Darwin Carrillo
CS4750
Natural Language Processing
Question
"""

import sys

"""
Extract nGrams from each word in the word bank
"""
def nGrammer(n,wb):
  #Holds all N-Grams
  nGramBank = dict([])
  #extract of nGrams and storage into nGramBank
  for w in wb:
    if len(w) >= n:
      for c in range(len(w)-n+1):
        key = w[c:c+n]
        nGramBank[key] = nGramBank.get(key, 0) + 1
  return nGramBank

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
Calculate Similarity score of two word banks
(xWB : x word bank
,yWB : y word bank)
"""
def similarityScore(n,xWB, yWB):

  #x/y nGram bank
  xNGB = nGrammer(n,xWB)
  yNGB = nGrammer(n,yWB)

  # number of nGram in the bank
  xNGNum = sum(xNGB.values())
  yNGNum = sum(yNGB.values())

  #difference score
  diff = 0.0

  #uqiue keys in x/y (x/yU)
  xKeys = set(xNGB.keys())
  yKeys = set(yNGB.keys())
  xU = xKeys-yKeys
  yU = yKeys- xKeys
  zU = xKeys & yKeys
  #sum all scores
  for x in xU:
    diff += (xNGB[x]*1.0)/xNGNum
  for y in yU:
    diff += (yNGB[y]*1.0)/yNGNum
  for z in zU:
    xFQ = (xNGB[z]*1.0)/xNGNum
    yFQ = (yNGB[z]*1.0)/yNGNum
    diff += abs(xFQ-yFQ)

  #Calculate simScore
  simScore = 1.0-(diff/2.0)
  return simScore

"""
Start Main Process
"""

#provide argument list
if len(sys.argv) < 4 :
  print "Usage: python tcomp1.py [MASTERFILE] [N(ngramSize)] [[CompareFile1] [CompareFile2] ...]"

#create list without script as an item
fileNames = sys.argv[1::]

#construct master file's wordbank
masterFile = fileNames.pop(0)
masterWB = wordBankBuilder(masterFile)

#nGram count
n = int(fileNames.pop(0))

#keep scores
scores = dict([])
#get scores of all files listed in command line argument
for f in fileNames:
  wb = wordBankBuilder(f)
  scores[f] = similarityScore(n,masterWB, wb)
  print "Sim('%s', '%s') = %.4f" % (masterFile, f, scores.get(f))

#print out file with max value
maxScore = max(scores, key=scores.get)
print "File most similar to %s is %s with a score of %.3f" % (masterFile, maxScore, scores.get(maxScore))
