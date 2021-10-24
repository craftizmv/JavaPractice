import java.util.HashSet;

public class ObjectEqualTest {
    private static HashSet<TunerDevice> HAUPPAUGE_TUNER_DEVICES;
    private static HashSet<TunerDevice> LARK_TUNER_DEVICES;

    private static class TunerDevice {
        private final int vendorId;
        private final int productId;

        private TunerDevice(int vendorId, int productId) {
            this.vendorId = vendorId;
            this.productId = productId;
        }

        /*private boolean equals(UsbDevice device) {
            return device.getVendorId() == vendorId && device.getProductId() == productId;
        }*/

        @Override
        public boolean equals(Object obj) {
            boolean result = false;
            TunerDevice tunerDevice;
            if (obj instanceof TunerDevice) {
                tunerDevice = (TunerDevice) obj;
                if (tunerDevice.productId == productId && tunerDevice.vendorId == vendorId) {
                    result = true;
                }
            }
            return result;
        }

        @Override
        public int hashCode() {
            /*int result = 17;
            result = 37 * result + vendorId;
            result = 37 * result + productId;*/
            return 1;
        }

    }


    private static class UsbDevice {

        private final int vendorId;
        private final int productId;

        UsbDevice(int vendorId, int productId) {
            this.vendorId = vendorId;
            this.productId = productId;
        }

        public int getVendorId() {
            return vendorId;
        }

        public int getProductId() {
            return productId;
        }

    }


    public static void main(String[] args) {
        TunerDevice device1 = new TunerDevice(1, 2);

        HAUPPAUGE_TUNER_DEVICES = new HashSet<>();

        HAUPPAUGE_TUNER_DEVICES.add(device1);

        /*if(device1.equals(device2)){
            System.out.println("True");
        } else {
            System.out.println("False");
        }*/

        UsbDevice usbDevice = new UsbDevice(1, 2);

//        System.out.println(" Result : " + HAUPPAUGE_TUNER_DEVICES.contains(new TunerDevice(usbDevice.getVendorId(), usbDevice.getProductId())));
        System.out.println(" Result : " + HAUPPAUGE_TUNER_DEVICES.contains(new UsbDevice(1,2)));

    }
}
