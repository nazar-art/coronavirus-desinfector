# Custom Spring implementation

Demo project with custom Spring framework implementations.

The main idea what Spring framework exactly does is the following snippet:

    @SneakyThrows
    public <T> T createObject(Class<T> implClass) {

        T t = create(implClass);

        configure(t);

        invokeInit(implClass, t);

        t = wrapWithProxyIfNeeded(implClass, t);

        return t;
    }

Literally it is:
- creates new instance
- configure it
- call init logic for object (2 Phase constructor)
- wrap with proxy when it is needed
- return bean to the container