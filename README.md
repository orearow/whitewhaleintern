# Intern challenge for White Whale





**Code Challenge: Gibberish Algorithm**
---------------------------------------

Challenge Overview
------------------

We are exticed taht you are intsereted in joiinng Wihte Wahle for the smumer.  Weoclme to yuor fsrit prommarging chanellge.  Yuor chnellage is to courtsnct a prrgoam taht tekas an Enilgsh txet snirtg as iupnt and rerutns rebadale giirebbsh lkie tihs.  It dseno’t mtaetr in waht oerdr the ltteres in a wrod are, but an iproamtnt tihng is taht the frsit and lsat ltteer be in the rghit pclae. The rset can be a taotl mses and you can sitll raed it whotuit a pboerlm.  Tihs is bcuseae the huamn mnid deos not raed ervey lteter by istlef, but the wrod as a wlohe.

**The Basics:**
  
  - You may use *almost any* programming language... it's your choice.  See the supported options [here](http://ideone.com/).
  - Your program should leave the first and last letter of each word in place and scramble the rest.
  - Your program should not scamble punctuation (.,-'...etc.), numbers, or upper-case abbreviations.
  - See the [/text_files] folder for sample text files. 

**Input/Output:**
 
  - Name your program as follows: `gibgen.xx` (where xx is variable based on the language you choose)
  - Your program should be able to read text input from a string passed into STDIN

- `gibgen.xx "This is a String"`
      - `cat mystringfile.txt | gibgen.xx`
  - Your program should output to the console.

_Note: This challenge is based on a popular word gibberish meme. You can improve the readability by looking at a [researcher's take](http://www.mrc-cbu.cam.ac.uk/people/matt.davis/cmabridge/) on the truths/myths of this meme, but this is not required._

What to do
----------
1. [Download](http://git-scm.com/downloads) & install Git on your machine

2. <a href="https://github.com/trentgillham/whitewhaleintern#fork-destination-box" class="btn grouped" data-method="POST" rel="nofollow" title="Fork">Fork</a> this project - Go [here](https://github.com/trentgillham/whitewhaleintern) and click the "Fork" button (located on the upper-right side of the screen)

2. Clone your new fork'd repository to your local machine - `git clone https://github.com/trentgillham/whitewhaleintern.git`
3. Complete the code challenge and fill out the Quick Start & Questions in the the README (see below)
4. `git add` and `git commit` your local repository as you go
4. Push your code and README back to Github occasionally - `git push origin master`
5. Email [gillham@whitewhaleanalytics.com](mailto:gillham@whitewhaleanalytics.com) with the Commit URL to your fork'd repository that you want reviewed. It should include at least 2 files: (1) your updated README with Coding Questions answered, and (2) your program (gibgen.xx)
   - Copy and paste the URL into the email along with your name... it should look something like this:
       - https://github.com/YOUR_USERNAME_HERE/whitewhaleintern.git

_Note: If you have any questions, email [gillham@whitewhaleanalytics.com](mailto:gillham@whitewhaleanalytics.com)._

Judging Criteria
----------------

Your responses to the **Coding Questions** at the bottom of this README are the *Most Important* part of this challenge. A working, fully fault-tolerant program that we just can't break, albeit awesome, is the least important.  Why is that?  Remember, we don't expect you to be expert programmers (just yet)... We want to see how you think through a problem.  


For completion by applicant
===========================

Quick Start
-----------

* Replace this text with instructions on how to execute your program
* What programming language did you use? See [here](http://ideone.com/) for the supported ones.
* Also tell us anything else the reviewer should know about your code


Coding Questions
----------------

Question 1: "How did you approach the problem?" (500 words or less)

First:
The very first thing I did when I was thinking about how to solve this problem was visualize what the input looked like. 
I knew that I had to parse through a textfile and I knew I had to treat every word individually as well as leave the punctuation alone. I decided that the best way to do this was to split the string (containing the contents of the file) at the whitespace and punctuation. This would make it easy to mess around with individual words.  

Second: I thought about my base case. The first sample string that I was using to test my program was: "Ore is very cool". 
and very soon I realized that any word that was shorter than four letters could not be scrambled because the only way to 
scramble a word like "is" or "Ore" will mess the first and last letters of the word. Because of this, I knew that when it was time to go to my scramble function, I had to check to make sure my word was larger than 3. According to the read me, the word could not be a number or a capital letter abbreviation, so I made sure to check for that as well. 

Third: I thought of the each word as a sandwich of sorts. The two un-scrambled letters were like the pieces of bread. While the middle of the string, the scrambled existed by itself until the bread was put on. I decided that I was going to 
store the first and last letters in variables, scramble up the middle, and then concatenate everything back together again in the right order. Storing the first and last letter was simple, and in order to scramble the middle letters I generated a random index to place each letter. The scrambling function reminded me of magnetic letters on a fridge. When you move one letter, you are changing its position with another letter. So I knew I wanted to generate a random position (in range) for each letter.
Later, I noticed that shorter words like "very" were sometimes not getting scrambled because there was only a 50% chance that the word would end up as "vrey". To stop this from happening I created a check that compares the newly scrambled word to the old word, if the words are the same, then I re-scramble. I also check to make sure that the middle of the word can be scrambled so that I do not enter an infinite loop. ex) the "oo" in cool can not be scrambled. 

Fourth: I checked my output. I noticed that because I re-added the whitespace, extra white-space was being generated between punctuation marks. (It ! Looked . Like . This ! ). To fix this, I simply stripped the extra white space before the punctuation marks.



Question 2: "What was the most difficult aspect of the solution?" (500 words or less)
It took me a little while to wrap my head around the punctuation and the white space around the punctuation of the sentence. Even now, there are still aspects about the punctuation of my program that can be improved. Right now, I am treating all punctuation marks the same. However, there is a difference between a period vs a dash vs an exclamation mark. With a dash, there is no white space between words, but the dash still needs to be skipped over, while with a quotation mark, whitespace depends on if the quotation mark is an open or closed mark. The dash also brought in more questions in my mind, would a word like “ice-box” be considered 6 letters? Could I scramble it up to get something like “ibe-cox” or would it still be treated like two  three letter words and therefore not get scrambled?
Having multiple cases for each special character seemed sort a bit superfluous so as I mentioned before I am treating all of the punctuation marks as if they were ending punctuation marks. Ex) the word “ice-box” would look like this “Ice- box” and would  be treated like two words. If this isn’t ideal, I do know how to fix this problem so just let me know!

Also, I hate to admit, but my java is a bit rusty. Lately I have been focousing on sql, php,html etc. so sometimes I would run into little mistakes like forgetting that I needed semicolons at the end of a line, or that the function for length is length() and not just length. I found that the refresher was pretty fun, and reminded me that I really should practice what I learn so I don't forget it over the summer. 


