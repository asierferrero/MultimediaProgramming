using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Ball : MonoBehaviour
{
    public float speed = 7;
    public Rigidbody2D rb;
    private Vector2 startPos;
    // Start is called before the first frame update
    void Start()
    {
        transform.position = startPos;
        Launch();
    }

    public void Launch()
    {
        float x = Random.Range(0, 2) == 0 ? -1: 1; // Balioa 0 bada -1 bueltatuko du, bestela 1
        float y = Random.Range(0, 2) == 0 ? -1 : 1;

        rb.velocity = new Vector2(speed*x, speed*y);
    }

    public void Reset()
    {
        rb.velocity = Vector2.zero;
        transform.position = startPos; // Gola sartzerakoan hasierako posiziora bueltatu
        Launch();
    }
}
