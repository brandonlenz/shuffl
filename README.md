# A Springboot Shuffl Implementation

## Summary
Originally built as an interview exercise, this project creates a base for a [shuffl](https://shuffl.ai)-esque utility 
that can take a given Organization and it's Users, and shuffle them into random groups of a desired size.

This app currently uses an H2 in memory DB to spin up some test data that can be interacted with.

The endpoint of interest satisfying the challenge criteria is `/shuffl` which will, by default, shuffle organization
with id 1 into groups of 2.

The `shuffl` endpoint can optionally take request parameters `organizationId` and `groupSize` to specify a different 
organization or different group size to target, e.g. `/shuffl?organizationId=1&groupSize=4`

## To run

Simply run `./gradlew bootRun` and the application will build and start on port `8080` by default.

Spring boot dev tools are enabled in this project, meaning that making a change and triggering a rebuild should allow
the application to hot-swap without needing to be restarted.
