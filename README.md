# IM status synchronizer

This application aims to add more meaning to the "available" status for daily used IMs (instant messaging apps). This is
achieved by tracking user activity on the workstation and making decisions over it.

> **Warning**: application works under a set of strict restrictions (later called assumptions). This is required to
> run the project smoothly in a POC manner. These assumptions are subject to change with the project growth. Please
> check the "Assumptions" section for more detailed overview.

## Assumptions

1. User is using only desktop version of Slack
2. Windows allows connecting to camera from several applications at once
    1. *e.g.: application is trying to capture a photo while user is on a Zoom call*
    2. Same for Linux
3. Workstation is being used by a single person at a time
4. User is logged in to a single Slack workspace

## Supported IMs

- [ ] Slack
- [ ] Zoom
- [ ] G Suite
- [ ] Outlook
- [ ] Discord

## How to run

### Prerequisites

You need to have the following software installed:

* Java 11 JDK
* Gradle (project intentionally is not shipped with a gradle wrapper)

### Configuration

All available configuration options are listed and documented in the `src/main/resources/application.yaml` file.

### Running in dev mode

The following command runs the project in development mode.

```shell
$ ./gradlew bootRun
```

## Contribution

Feel free to contribute to this project if you're interested in it. If you find that there is something you
would like to see in the context of this app, please open a new issue, and I will do my best.