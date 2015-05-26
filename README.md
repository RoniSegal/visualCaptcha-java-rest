visualCaptcha-java-rest [![Build Status](https://travis-ci.org/tillkuhn/visualCaptcha-java-rest.svg?branch=master)](https://travis-ci.org/tillkuhn/visualCaptcha-java-rest)
========================

Fork of bdotzour's visualCaptcha-java project (Plain Java Servlet backend for visualCaptcha)
using Spring RestController as opposed to Servlets.

Runs as a standalone application with Spring Boot so all you need to
do is run `mvn spring-boot:run` and point your browser to http://localhost:8080!

## Installation

```
git clone https://github.com/tillkuhn/visualCaptcha-java-rest.git
mvn verify
```

## Run application

```
mvn spring-boot:run
```

## Run tests

```
mvn test
```

## Todos

* Complete Implementation for Audio
* Dockerize
* Spring Integration tests

## Attention

Work is still in progress and not yet finished, but feel free to contribute!

## API

Copied from [https://github.com/emotionLoop/visualCaptcha-PHP/blob/master/README.md](https://github.com/emotionLoop/visualCaptcha-PHP/blob/master/README.md)

visualCaptcha, since 5.0, uses an API for increased security and to become back-end-agnostic (that's why you can easily plug-in a Vanilla JS, AngularJS, or jQuery front-end without changing anything).

It expects the following routes to exist, which we've put in this sample, using Slim (just to make it easier).

You are expected to have these routes in your implementation, but you can change them in visualCaptcha's front-end config.

### GET `/start/:howmany`

This route will be the first route called by the front-end, which will generate and store session data.

Parameters:

- `howmany` is required, the number of images to generate.

### GET `/image/:index`

This route will be called for each image, to get it and show it, by index.

Parameters:

- `index` is required, the index of the image you want to get.

### GET `/audio(/:type)`

This route will be called for the audio file, to get it and play it, either the mp3 or ogg file.

Parameters:

- `type` is optional, the audio file format defaults to `mp3`, but can also be `ogg`.

### POST `/try` 

This is just a sample route, where we post the form to, and where the visualCaptcha validation takes place.


## License

Check the LICENSE file.
