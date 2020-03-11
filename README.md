```
.
├── README.md
├── bin
│   └── main
│       └── frc
│           └── robot
│               ├── Main.class
│               ├── OI.class
│               ├── PID.class
│               ├── Robot.class
│               ├── RobotMap.class
│               ├── commands
│               │   ├── DistanceAlignment.class
│               │   ├── IndexBall.class
│               │   ├── ManualIndex.class
│               │   ├── ManualShoot.class
│               │   ├── RotationAlignment.class
│               │   ├── UpdateLimelight.class
│               │   ├── Vomit.class
│               │   ├── archive
│               │   │   └── automaticcommands
│               │   │       ├── IndexBallAutomatic.class
│               │   │       └── IntakeBallAutomatic.class
│               │   ├── autonomous
│               │   │   ├── DriveBackward.class
│               │   │   ├── DriveForward.class
│               │   │   ├── IndexAndShoot.class
│               │   │   ├── LeftAuto.class
│               │   │   ├── MiddleAuto.class
│               │   │   ├── RunShooter.class
│               │   │   ├── TurnLeft.class
│               │   │   └── TurnRight.class
│               │   ├── defaultcommands
│               │   │   ├── ArcadeDrive.class
│               │   │   ├── AutomatedBallIndex.class
│               │   │   └── RunIntake.class
│               │   └── onofftoggles
│               │       ├── DriveMode.class
│               │       └── IntakeState.class
│               └── subsystems
│                   ├── ColorSensor.class
│                   ├── DriveBase.class
│                   ├── Elevator.class
│                   ├── Index.class
│                   ├── Intake.class
│                   ├── Limelight.class
│                   └── Shooter.class
├── build
│   ├── classes
│   │   └── java
│   │       └── main
│   │           └── frc
│   │               └── robot
│   │                   ├── Main.class
│   │                   ├── OI.class
│   │                   ├── PID.class
│   │                   ├── Robot.class
│   │                   ├── RobotMap.class
│   │                   ├── commands
│   │                   │   ├── DistanceAlignment.class
│   │                   │   ├── IndexBall.class
│   │                   │   ├── ManualIndex.class
│   │                   │   ├── ManualShoot.class
│   │                   │   ├── RotationAlignment.class
│   │                   │   ├── UpdateLimelight.class
│   │                   │   ├── Vomit.class
│   │                   │   ├── archive
│   │                   │   │   └── automaticcommands
│   │                   │   │       ├── IndexBallAutomatic.class
│   │                   │   │       └── IntakeBallAutomatic.class
│   │                   │   ├── autonomous
│   │                   │   │   ├── DriveBackward.class
│   │                   │   │   ├── DriveForward.class
│   │                   │   │   ├── IndexAndShoot.class
│   │                   │   │   ├── LeftAuto.class
│   │                   │   │   ├── MiddleAuto.class
│   │                   │   │   ├── RunShooter.class
│   │                   │   │   ├── TurnLeft.class
│   │                   │   │   └── TurnRight.class
│   │                   │   ├── defaultcommands
│   │                   │   │   ├── ArcadeDrive.class
│   │                   │   │   ├── AutomatedBallIndex.class
│   │                   │   │   └── RunIntake.class
│   │                   │   └── onofftoggles
│   │                   │       ├── DriveMode.class
│   │                   │       └── IntakeState.class
│   │                   └── subsystems
│   │                       ├── ColorSensor.class
│   │                       ├── DriveBase.class
│   │                       ├── Elevator.class
│   │                       ├── Index.class
│   │                       ├── Intake.class
│   │                       ├── Limelight.class
│   │                       └── Shooter.class
│   ├── generated
│   │   └── sources
│   │       └── annotationProcessor
│   │           └── java
│   │               └── main
│   ├── libs
│   │   └── InfiniteRecharge2020.jar
│   └── tmp
│       ├── compileJava
│       ├── expandedArchives
│       │   ├── cscore-cpp-2020.1.1-osxx86-64.zip_1d66cd6f0b40d7d39ad576df711510e5
│       │   │   └── osx
│       │   │       └── x86-64
│       │   │           └── shared
│       │   │               ├── libcscore.dylib
│       │   │               └── libcscorejni.dylib
│       │   ├── hal-cpp-2020.1.1-osxx86-64.zip_82cb781f159470ce9817cca21dc15c64
│       │   │   └── osx
│       │   │       └── x86-64
│       │   │           └── shared
│       │   │               ├── libwpiHal.dylib
│       │   │               └── libwpiHaljni.dylib
│       │   ├── ntcore-cpp-2020.1.1-osxx86-64.zip_7a3b2e86971f2f93906050f4541e9320
│       │   │   └── osx
│       │   │       └── x86-64
│       │   │           └── shared
│       │   │               ├── libntcore.dylib
│       │   │               └── libntcorejni.dylib
│       │   ├── opencv-cpp-3.4.7-2-osxx86-64.zip_bf5014b94d90f1a258935ad5dd15f44e
│       │   │   └── osx
│       │   │       └── x86-64
│       │   │           └── shared
│       │   │               ├── libopencv_calib3d.3.4.dylib
│       │   │               ├── libopencv_core.3.4.dylib
│       │   │               ├── libopencv_features2d.3.4.dylib
│       │   │               ├── libopencv_flann.3.4.dylib
│       │   │               ├── libopencv_highgui.3.4.dylib
│       │   │               ├── libopencv_imgcodecs.3.4.dylib
│       │   │               ├── libopencv_imgproc.3.4.dylib
│       │   │               ├── libopencv_java347.dylib
│       │   │               ├── libopencv_ml.3.4.dylib
│       │   │               ├── libopencv_objdetect.3.4.dylib
│       │   │               ├── libopencv_photo.3.4.dylib
│       │   │               ├── libopencv_shape.3.4.dylib
│       │   │               ├── libopencv_stitching.3.4.dylib
│       │   │               ├── libopencv_superres.3.4.dylib
│       │   │               ├── libopencv_video.3.4.dylib
│       │   │               ├── libopencv_videoio.3.4.dylib
│       │   │               └── libopencv_videostab.3.4.dylib
│       │   └── wpiutil-cpp-2020.1.1-osxx86-64.zip_47628e899ce8d4dda8e9b7361893f75e
│       │       └── osx
│       │           └── x86-64
│       │               └── shared
│       │                   ├── libwpiutil.dylib
│       │                   └── libwpiutiljni.dylib
│       ├── jar
│       │   └── MANIFEST.MF
│       └── jniExtractDir
│           ├── libcscore.dylib
│           ├── libcscorejni.dylib
│           ├── libntcore.dylib
│           ├── libntcorejni.dylib
│           ├── libopencv_calib3d.3.4.dylib
│           ├── libopencv_core.3.4.dylib
│           ├── libopencv_features2d.3.4.dylib
│           ├── libopencv_flann.3.4.dylib
│           ├── libopencv_highgui.3.4.dylib
│           ├── libopencv_imgcodecs.3.4.dylib
│           ├── libopencv_imgproc.3.4.dylib
│           ├── libopencv_java347.dylib
│           ├── libopencv_ml.3.4.dylib
│           ├── libopencv_objdetect.3.4.dylib
│           ├── libopencv_photo.3.4.dylib
│           ├── libopencv_shape.3.4.dylib
│           ├── libopencv_stitching.3.4.dylib
│           ├── libopencv_superres.3.4.dylib
│           ├── libopencv_video.3.4.dylib
│           ├── libopencv_videoio.3.4.dylib
│           ├── libopencv_videostab.3.4.dylib
│           ├── libwpiHal.dylib
│           ├── libwpiHaljni.dylib
│           ├── libwpiutil.dylib
│           └── libwpiutiljni.dylib
├── build.gradle
├── gradle
│   └── wrapper
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── gradlew
├── gradlew.bat
├── settings.gradle
├── src
│   └── main
│       ├── deploy
│       │   └── example.txt
│       └── java
│           └── frc
│               └── robot
│                   ├── Main.java
│                   ├── OI.java
│                   ├── PID.java
│                   ├── Robot.java
│                   ├── RobotMap.java
│                   ├── commands
│                   │   ├── DistanceAlignment.java
│                   │   ├── IndexBall.java
│                   │   ├── ManualIndex.java
│                   │   ├── ManualShoot.java
│                   │   ├── RotationAlignment.java
│                   │   ├── UpdateLimelight.java
│                   │   ├── Vomit.java
│                   │   ├── archive
│                   │   │   └── automaticcommands
│                   │   │       ├── IndexBallAutomatic.java
│                   │   │       └── IntakeBallAutomatic.java
│                   │   ├── autonomous
│                   │   │   ├── DriveBackward.java
│                   │   │   ├── DriveForward.java
│                   │   │   ├── IndexAndShoot.java
│                   │   │   ├── LeftAuto.java
│                   │   │   ├── MiddleAuto.java
│                   │   │   ├── RunShooter.java
│                   │   │   ├── TurnLeft.java
│                   │   │   └── TurnRight.java
│                   │   ├── defaultcommands
│                   │   │   ├── ArcadeDrive.java
│                   │   │   ├── AutomatedBallIndex.java
│                   │   │   └── RunIntake.java
│                   │   └── onofftoggles
│                   │       ├── DriveMode.java
│                   │       └── IntakeState.java
│                   └── subsystems
│                       ├── ColorSensor.java
│                       ├── DriveBase.java
│                       ├── Elevator.java
│                       ├── Index.java
│                       ├── Intake.java
│                       ├── Limelight.java
│                       └── Shooter.java
└── vendordeps
    ├── Phoenix.json
    ├── REVColorSensorV3.json
    └── WPILibOldCommands.json

71 directories, 165 files
```
