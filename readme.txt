curl -i -X POST -H 'Content-Type:application/json' -d '{ "name" : "transactions"}' localhost:8080/pages

HTTP/1.1 201 Created
Server: Apache-Coyote/1.1
Location: http://localhost:8080/pages/4
Content-Length: 0
Date: Sat, 18 Oct 2014 22:22:04 GMT

curl -i localhost:8080/pages/4

HTTP/1.1 200 OK
Server: Apache-Coyote/1.1
Content-Type: application/hal+json
Transfer-Encoding: chunked
Date: Sat, 18 Oct 2014 22:22:30 GMT

{
  "name" : "transactions",
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/pages/4"
    },
    "portal" : {
      "href" : "http://localhost:8080/pages/4/portal"
    }
  }
}

curl -i http://localhost:8080/pages/4/portal

HTTP/1.1 404 Not Found
Server: Apache-Coyote/1.1
Content-Length: 0
Date: Sat, 18 Oct 2014 22:23:03 GMT

curl -i -X PUT -H 'Content-Type:text/uri-list' -d localhost:8080/portals/1 localhost:8080/pages/4/portal

As mentioned before, PATCH updates parts of a resource while PUT completely replaces one.
You might think changing a relationship would use a PATCH, but the semantics are that we are
replacing the whole team relationship, so we must use PUT.

HTTP/1.1 204 No Content
Server: Apache-Coyote/1.1
Date: Sat, 18 Oct 2014 22:24:26 GMT

curl -i http://localhost:8080/pages/4/portal

HTTP/1.1 200 OK
Server: Apache-Coyote/1.1
Content-Location: http://localhost:8080/portals/1
Content-Type: application/hal+json
Transfer-Encoding: chunked
Date: Sat, 18 Oct 2014 22:24:47 GMT

{
  "name" : "Haliho Gulf retail banking",
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/portals/1"
    },
    "pages" : {
      "href" : "http://localhost:8080/portals/1/pages"
    }
  }
}

curl -i -X PATCH -H "Content-Type:application/json" -d '{"name":"signin"}' localhost:8080/pages/1

HTTP/1.1 204 No Content
Server: Apache-Coyote/1.1
Date: Sat, 18 Oct 2014 22:27:50 GMT

curl -i -X DELETE localhost:8080/pages/2

HTTP/1.1 204 No Content
Server: Apache-Coyote/1.1
Date: Sat, 18 Oct 2014 22:28:47 GMT

curl -i localhost:8080/pages/2

HTTP/1.1 404 Not Found
Server: Apache-Coyote/1.1
Content-Length: 0
Date: Sat, 18 Oct 2014 22:29:18 GMT