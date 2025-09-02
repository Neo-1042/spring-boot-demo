# Annotation Autowiring and Qualifiers

If you have multiple implementations of \<interface\>, how to
know which one to inject?

e.g. TennisCoach, CricketCoach, BaseballCoach, TrackCoach all
implement the 'Coach' interface. Which one will Spring pick?

Error message:
<span style="color:red">
Parameter 0 of constructor in com.neo_1042.springcoredemo.rest.DemoController
required a single bean, but 4 were found:</br>
baseballCoach</br>
tennisCoach</br>
trackCoach
</span>

Solution: be specific! Use the ```@Qualifier``` annotation with
the bean id (same name as the class, camelCase)

File: DemoController.java. CONSTRUCTOR INJECTION.
```java
    @Autowired
    public DemoController(@Qualifier("tennisCoach") Coach theCoach) {
        myCoach = theCoach;
    }
```

File: DemoController.java. SETTER INJECTION.
```java
    @Autowired
    public void setCoach(@Qualifier("cricketCoach") Coach theCoach) {
        myCoach = theCoach;
    }
```