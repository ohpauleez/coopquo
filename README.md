
coopquo : A collective intelligence library for Clojure
=======================================================

TODO: Description



Usage and Examples
==================

TODO



Installation
============

### With Leiningen or Cake

TODO

### Via Source

TODO


TODO
====

* Consider using Trammel for contract based design
    This could work like checked operations, so that users could also use the faster, unchecked forms of the call
* Consider rolling in lein-multi for 1.2/1.3 work
* Consider using Records for the preference map for speed
* Consider using stream processing for the preference map and reading/updating directly into mongo
    This would allow the service/library to be completely async wihout any extra work.  This also allows the library to scale out as a service naturally
* Additionally, make things (such as recommendations/predictions) lazy where it makes sense (which should be most places)
* Roll in SlopeOne recommendations
* Finish up user and item based collaborative filering
* Consider rolling in mahout wrappers and interoperability


Hacking
=======

### Using TMUX or screen

If you want to start a new tmux server, cd to the project root dir, just type:
    tmux -f tmux-screen/coopquo.tmux.conf
otherwise you can start a new session:
    tmux `cat tmux-screen/coopquo.tmux.newsession`
You can also use screen:
    screen -c tmux-screen/coopquo-screenrc -S coopquo


### VimClojure tips

Start a nailgun (which will also open a repl),
run the following command from the project root:
    script/nailgun
You can also run a rlwrap'd REPL that VimClojure can connect to:
    lein repl
And then call the Nailgun server function:
    (runnail)

Here are helpful commands
    * \rt - run tests in the given namespace
    * \lw - lookup word
    * \li - lookup interactive
    * \gw - goto word
    * \sw - source lookup word
    * \el - eval line
    * \ep - eval paragraph
    * \ef - eval file
    * \me - macroexpand
    * \m1 - macroexpand1
    * \rf - require the file

### Paredit.vim tips

I also make use of the paredit.vim file from the slimv.vim plugin. This assumes your <leader> is \
    * :call ToggleParedit - toggle it on and off.
    * \W wrap in paren (works with visual selection too)
    * \J join paren - (a)(b) -> (a b)
    * \O split paren - (a b) -> (a)(b)
    * \S splice paren - ((a b)) -> (a b)
Wrapping can also be tailored, and used on a visual block:
    * \w"
    * \w[
    * \w(


### Running the tests

From the project root, `./script/lazytest` will run all the tests.
To start a test watcher, `./script/lazytest-watch`


License
=======

    Copyright (C) 2010 Paul deGrandis. All rights reserved.
    Distributed under the Eclipse Public License, the same as Clojure.
	
	The use and distribution terms for this software are covered by the 
	Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php) 
	which can be found in the file LICENSE.html at the root of this distribution. 
	By using this software in any fashion, you are agreeing to be bound by the terms of this license. 
	You must not remove this notice, or any other, from this software.

