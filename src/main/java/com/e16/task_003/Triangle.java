package com.e16.task_003;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Triangle {
    private static final Logger log = LoggerFactory.getLogger(Triangle.class);
    private final Point a;
    private final Point b;
    private final Point c;
    private final double ab;
    private final double ac;
    private final double bc;

    public double getAB() {
        return ab;
    }

    public double getAC() {
        return ac;
    }

    public double getBC() {
        return bc;
    }

    public Triangle(final Point a, final Point b, final Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
        log.info("Creating triangle with points {}, {}; {}, {}; {}, {}",
                a.getX(), a.getY(), b.getX(), b.getY(), c.getX(), c.getY());
        ab = a.distanceTo(b);
        ac = a.distanceTo(c);
        bc = b.distanceTo(c);
        log.info("Creating lines from points {}, {}, {}", ab, ac, bc);
    }

    /**
     * Check Triangle to exists
     * Triangle Inequality Theorem
     * The sum of two sides of a triangle must be greater than the third side
     *
     * @return true if triangle exist
     */
    public boolean exists() throws IllegalStateException {
        log.info("Check Triangle with sides {}, {}, {} to exists", ab, ac, bc);
        return ab + ac > bc && ab + bc > ac && ac + bc > ab;
    }

    /**
     * Calculate area of triangle, if triangle is {@link #exists()}
     *
     * @return area of triangle
     * @throws IllegalStateException if triangle not exist
     */
    public double area() {
        if (!this.exists()) {
            log.info("Throw exception with message Triangle not exist");
            throw new IllegalStateException("Triangle not exist");
        }
        log.info("Calculate area of triangle with points {}, {}; {}, {}; {}, {}",
                a.getX(), a.getY(), b.getX(), b.getY(), c.getX(), c.getY());
        return Math.abs((a.getX() - c.getX()) * (b.getY() - c.getY())
                - (b.getX() - c.getX()) * (a.getY() - c.getY()));
    }
}
