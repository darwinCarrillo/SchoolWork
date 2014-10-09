#########################################################
##  CS 4750 (Fall 2014), Assignment #1, Question #3    ##
##   Script File Name: index1.py                       ##
##       Student Name: Darwin Carrillo                 ##
##         Login Name: drc610                          ##
##              MUN #: 201153210                       ##
#########################################################

"""
Ignored word list line locator
The following program outputs the words and the line in a text file that do not
occur in "Ignored list" text file
Author: Darwin Carrillo
CS4750
Natural Language Processing
Question 2
"""

import sys
from collections import defaultdict

"""
Parse through file
"""
def wordBankBuilder(line):
  #Holds the words extracted from the 'string' argument
  word_Bank = []
  #temporarily holds a word for the wordBank
  temp_Word = ""

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
Start Main Process
"""

if len(sys.argv) < 4 :
  print "Usage: python tcomp3.py [WORDFILE] [TEXTFILE] [INDEXFILE]"

#handle system arguments
iWFN = sys.argv[1]
txtFN = sys.argv[2]


#open ignore words file(iWF) with ignore word file name (iWFN)
iWF = open(iWFN, "r")
#store ignored words (iW)
iW = []
#populate list
for i in iWF:
  iW.append(i.rstrip())

#open textfile
txtF = open(txtFN, "r")
#store index list
indexList = defaultdict(list)
#populate txtFL
for i,l in enumerate(txtF):
  #iterate through each line to find words not in the index
  tempWB = wordBankBuilder(l)
  #search the temporary word bank for words not in the index
  for tempW in tempWB:
    #if the word is not in the index, record keys and line it occured
    if tempW not in iW:
      indexList[tempW].append(i+1)

#open file to write to
index = open("index1.txt", "w")
#print results
for k in sorted(indexList):
  toWrite = k+": "+" ".join(str(x) for x in indexList[k])+"\n"
  index.write(toWrite)
  print toWrite.rstrip()
print "Execution Complete. Open your index file to see results."
index.close()
