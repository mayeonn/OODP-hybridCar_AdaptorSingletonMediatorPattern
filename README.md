# 20230414 OODP Programming Test - Adaptor, Singleton, Mediator Patterns  
Simulate a **_hybrid car_** which is driven both by a conventional fuel engine and also electric motors
------------
  
- Depending on the charging status of its main battery, the car changes its driving mode
among fuel mode, hybrid mode, and electric mode
- Charging status of the main battery is determined by a random number generator
with the range of 1~100.

#
**_In fuel mode_**
- the car is driven **_only by gas/fuel engine_** while charging the battery by a electric generator run by the gas/fuel engine.  
- there are two situations - one with **_battery low level_**, another with **_almost empty battery level_**.  
- In both situations, the vehicle is in fuel mode. When the battery is almost empty, the **_backup battery_** will be used.
  The charging status of the backup battery is made by a random number generator with the range of 50~100,
#
**_In hybrid mode_**
- In hybrid mode with a **_medium main-battery level_**, the car is **_powered by both gas/fuel engine and an electric motor_** while charging battery both by conventional electric generator and regenerative braking system.
#
**_In electric mode_**
- In electric mode with a **_high main-battery level_**, the car is driven only by electricity without using gas/fuel while charging battery only by the regenerative braking system.
#
- **_The current mediator singleton_** tracks main battery level, the usage of the backup battery, and the level of the backup battery when it is used.
- **_The mediator_** simply mediates the use of backup battery only for fuel mode in this version.
#
