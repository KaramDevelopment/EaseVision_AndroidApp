from watson_iot import Device
import utime as time
import time, network, sensor, image, time, math, ustruct

SSID='Karam2' # Network SSID
KEY='1F9018396A'  # Network key

threshold_list = [(0, 255)]
i = 0

min_temp_in_celsius = 32.0
max_temp_in_celsius = 41.0

# Init wlan module and connect to network
print("Trying to connect... (may take a while)...")
wlan = network.WINC()
wlan.connect(SSID, key=KEY, security=wlan.WPA_PSK)
print(wlan.ifconfig())

device = Device(
    device_id="Arduino-1",
    device_type= "Arduino",
    org="mo9vcr",
    token="dSSbrF0LJGrfs@N_4r"
)

print("Resetting Lepton...")
sensor.reset()
sensor.ioctl(sensor.IOCTL_LEPTON_SET_MEASUREMENT_MODE, True)
sensor.ioctl(sensor.IOCTL_LEPTON_SET_MEASUREMENT_RANGE, min_temp_in_celsius, max_temp_in_celsius)
print("Lepton Res (%dx%d)" % (sensor.ioctl(sensor.IOCTL_LEPTON_GET_WIDTH),
                              sensor.ioctl(sensor.IOCTL_LEPTON_GET_HEIGHT)))
print("Radiometry Available: " + ("Yes" if sensor.ioctl(sensor.IOCTL_LEPTON_GET_RADIOMETRY) else "No"))


sensor.set_pixformat(sensor.GRAYSCALE)
sensor.set_framesize(sensor.QQVGA)
sensor.skip_frames(time=5000)
clock = time.clock()

def start_ffc():
    sensor.ioctl(sensor.IOCTL_LEPTON_RUN_COMMAND, 0x0242)

def get_ffc_running():
    state = ustruct.unpack("<I", sensor.ioctl(sensor.IOCTL_LEPTON_GET_ATTRIBUTE, 0x0244, 2))[0]
    # LEP_SYS_STATUS_WRITE_ERROR == -2
    # LEP_SYS_STATUS_ERROR == -1
    # LEP_SYS_STATUS_READY == 0
    # LEP_SYS_STATUS_BUSY == 1
    # LEP_SYS_FRAME_AVERAGE_COLLECTING_FRAMES == 2
    return state

def map_g_to_temp(g):
     return (g*(max_temp_in_celsius - min_temp_in_celsius)/255)+ min_temp_in_celsius

def get_temp(x,y,w,h):
    stats = img.get_statistics(thresholds=threshold_list, roi=(x,y,w,h))
    return cToF((map_g_to_temp(stats.mean())))



def cToF(temp):
    return (temp * 1.8 + 32)

def publish (temp):
    device.publishEvent('Temperature Data', {'Temperature': temp})

# connect to MQTT broker
device.connect()
start_ffc()


while True:
    img = sensor.snapshot()
    screenTemp = get_temp(0,0,160,120)
    publish(20)
    time.sleep(30000);
    #if (screenTemp > 90):
        #sensor.snapshot().save("temp.jpg")
        #send image to get cordinates
        #getTemp of coordinates
        #publish temp

    #i+=1
    #if i % 100 == 0:
     #   start_ffc()





