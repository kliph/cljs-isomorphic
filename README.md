# cljs-isomorphic

Following along with http://blog.testdouble.com/posts/2016-01-21-isomorphic-clojurescript.html

## Installation

Download from http://github.com/kliph/cljs-isomorphic

    yarn install

## Usage

### Building the server

    lein cljsbuild once server

### Build both client and server code

    lein cljsbuild once app server

### Running the server

    node resources/public/js/server-side/server.js

## License

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
