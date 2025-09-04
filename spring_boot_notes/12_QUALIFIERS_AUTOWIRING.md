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

## @Primary Annotation (No need for @Qualifier)

"I simply need a coach, I don't care which one"

Add only one ```@Primary``` to the desired implementation.

File: TrackCoach.java
```java
@Component
@Primary
public class TrackCoach implements Coach {

    @Override
    public String getDailyWorkout() {

        return "USAIN BOLT IS THE BEST";
    }
}
```

When you add the ```@Primary``` annotation to one of the multiple
implementations, you should remove the ```@Qualifier``` annotation
in the DemoController.java file.

## Which one: @Primary or @Qualifier?

```@Primary``` leaves up to the implementation classes. Choose this
if you want one implementation class to be chosen as default.
(You can add a @Qualifier to override the @Primary annotation)

```@Qualifier``` is specific on which bean you want (Recommended)

